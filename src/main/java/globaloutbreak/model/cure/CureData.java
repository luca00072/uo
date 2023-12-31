package globaloutbreak.model.cure;

import java.util.List;
import java.util.Optional;

import globaloutbreak.model.region.Region;
import globaloutbreak.model.cure.prioriry.Priority;

/**
 * A set of usefull Data about the cure status.
 */
public interface CureData {

    /**
     * Returns the progress of the cure.
     * 
     * @return
     *         progress
     */
    int getProgress();

    /**
     * Returns the remaing days before the cure is completed.
     * 
     * @return
     *         days
     */
    Optional<Integer> getRemainingDays();

    /**
     * Returns the {@code Region} with the major contribution to the cure.
     * 
     * @return
     *         regions
     */
    List<Region> getMajorContributors();

    /**
     * Returns the {@link Priority}.
     * 
     * @return
     *         {@code Priority}
     */
    Priority gePriority();
}
