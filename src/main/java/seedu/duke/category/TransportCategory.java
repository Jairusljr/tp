package seedu.duke.category;

/**
 * Represents the TRANSPORT expense category.
 *
 * <p>Assigned sort order {@code 2}, meaning transport expenses appear
 * second when the expense list is sorted by category.</p>
 */
public class TransportCategory extends Category {

    /**
     * {@inheritDoc}
     *
     * @return {@code "TRANSPORT"}
     */
    @Override public String getName() {
        return "TRANSPORT";
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code 2}
     */
    @Override public int getSortOrder() {
        return 2;
    }
}
