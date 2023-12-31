package globaloutbreak.model.voyage;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import globaloutbreak.model.pair.Pair;
import globaloutbreak.model.region.MeansState;
import globaloutbreak.model.region.Region;
import globaloutbreak.model.region.TransmissionMean;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 */
public final class VoyagesImpl implements Voyages {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Map<String, Pair<Integer, Integer>> sizeAndNameOfMeans;
    private final Random rand = new Random();

    /**
     * 
     * @param sizeAndNameOfMeans
     */
    public VoyagesImpl(final Map<String, Pair<Integer, Integer>> sizeAndNameOfMeans) {
        this.sizeAndNameOfMeans = new HashMap<>(sizeAndNameOfMeans);
    }

    @Override
    public List<Voyage> extractMeans(final List<Region> regions,
            final Map<String, Float> pot) {

        final List<Voyage> extractedMeans = new LinkedList<>();
        sizeAndNameOfMeans.forEach((means, size) -> {
            final List<Region> newRegions = regions.stream()
                    .filter(k -> checkIfMeansAreOpen(k.getTrasmissionMeans(), means)).toList();
            if (!newRegions.isEmpty()) {
                for (int i = 0; i < size.getX(); i++) {
                    final Pair<Region, Region> partDest = extractRegion(newRegions, means);
                    if(partDest.getX() != null) {
                        final Region part = newRegions
                                .stream()
                                .filter(k -> k.getColor() == partDest.getX().getColor()).toList().get(0);
                        final float prob = part.calcPercInfected() + pot.get(means);
                        logger.info("prob " + prob + " infected " + numInfected(prob, size.getY()));
                        final Voyage voyage = new VoyageImpl(means, partDest.getX().getColor(), partDest.getY().getColor(),
                                numInfected(prob, size.getY()));
                        extractedMeans.add(voyage);
                    }
                }
            }
        });
        return extractedMeans;
    }

    private Pair<Region, Region> extractRegion(final List<Region> newRegions, final String type) {
        final Region region = newRegions.get(rand.nextInt(0, newRegions.size()));
        List<Region> efectieRegions = new LinkedList<>(newRegions);
        switch (type) {
            case "terra":
                efectieRegions = findRegionsByName(newRegions, region.getTrasmissionMeans()
                        .stream()
                        .filter(k -> k.getType().equals(type))
                        .findFirst().get()
                        .getReachableStates().get());
                break;
            default:
                break;
        }
        if( efectieRegions.size() > 0) {
            Region dest = efectieRegions.get(rand.nextInt(0, efectieRegions.size()));
            while (dest.getColor() == region.getColor()) {
                if( efectieRegions.size() > 0) {
                    dest = efectieRegions.get(rand.nextInt(0, efectieRegions.size()));
                    efectieRegions.remove(dest);
                }
            }
            return new Pair<>(region, dest);
        }
        return new Pair<>(null, null);
    }

    private List<Region> findRegionsByName(final List<Region> regions, final List<String> nameRegions) {
        final List<Region> rs = new LinkedList<>();
        regions.forEach(k -> {
            nameRegions.forEach(s -> {
                if (k.getName().equals(s)) {
                    rs.add(k);
                }
            });
        });
        return rs;
    }

    private boolean checkIfMeansAreOpen(final List<TransmissionMean> list, final String means) {
        final Long open = list.stream().filter(k -> k.getType().equals(means) && k.getState().equals(MeansState.OPEN))
                .count();
        return open > 0;
    }

    private Integer numInfected(final float prob, final Integer size) {
        final int prod = Math.round(size * prob);
        if (prod > size) {
            logger.warn("too many seatsI'll fill the plane");
            return size;
        } else if (rand.nextInt(0, 100) >= (prob * 100)) {
            return prod;
        }
        return 0;
    }

    @Override
    public List<String> getMeans() {
        return new LinkedList<>(sizeAndNameOfMeans.keySet());
    }

}
