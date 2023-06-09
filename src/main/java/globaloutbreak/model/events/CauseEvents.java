package globaloutbreak.model.events;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import globaloutbreak.model.pair.Pair;
import globaloutbreak.model.region.Region;
/**
 * Implement. of CauseEventInt.
 */
public final class CauseEvents implements CauseEventInt {
    private final List<Event> events;
    private static final Random RANDOM = new Random();
    /**
     * 
     * @param events
     */
    public CauseEvents(final List<Event> events) {
        this.events = new LinkedList<>(events);
    }

    @Override
    public Optional<Pair<Region, Integer>> causeEvent(final List<Region> regions) {
        final Event event = events.get(RANDOM.nextInt(0, events.size() - 1));
        if (RANDOM.nextInt(0, 100) <= event.getProbOfHapp()) {
            final Region r = regions.get(RANDOM.nextInt(0, events.size() - 1));
            return Optional.of(new Pair<>(r, event.calcDeath(r.getPopTot())));
        } else {
            return Optional.empty();
        }
    }

}
