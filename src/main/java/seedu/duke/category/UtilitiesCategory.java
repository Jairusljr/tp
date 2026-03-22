package seedu.duke.category;

/**
 * Represents the UTILITIES expense category.
 *
 * <p>Assigned sort order {@code 4}, meaning utilities expenses appear
 * fourth when the expense list is sorted by category.</p>
 */
public class UtilitiesCategory extends Category {

    /**
     * {@inheritDoc}
     *
     * @return {@code "UTILITIES"}
     */
    @Override public String getName() {
        return "UTILITIES";
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code 4}
     */
    @Override public int getSortOrder() {
        return 4;
    }
}
