package seedu.duke.category;

/**
 * Represents the OTHER expense category.
 *
 * <p>Assigned sort order {@code 5}, meaning other expenses appear
 * fifth (currently last) when the expense list is sorted by category.</p>
 */
public class OtherCategory extends Category {

    /**
     * {@inheritDoc}
     *
     * @return {@code "OTHER"}
     */
    @Override public String getName() {
        return "OTHER";
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code 5}
     */
    @Override public int getSortOrder() {
        return 5;
    }
}
