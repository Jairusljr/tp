package seedu.duke.category;

/**
 * Represents the FOOD expense category.
 *
 * <p>Assigned sort order {@code 1}, meaning food expenses appear
 * first when the expense list is sorted by category.</p>
 */
public class FoodCategory extends Category{

    /**
     * {@inheritDoc}
     *
     * @return {@code "FOOD"}
     */
    @Override public String getName() {
        return "FOOD";
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code 1}
     */
    @Override public int getSortOrder() {
        return 1;
    }
}
