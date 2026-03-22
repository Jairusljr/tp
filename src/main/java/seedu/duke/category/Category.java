package seedu.duke.category;

import java.util.logging.Logger;
import seedu.duke.util.LoggerUtil;

/**
 * Represents a classification label for a financial expense.
 *
 * <p>Each concrete subclass defines a specific category (e.g., FOOD, TRANSPORT)
 * and its sort priority for ordered display in the expense list.</p>
 *
 * <p>Categories are compared by their hard-coded sort order via {@link #compareTo},
 * allowing expense lists to be sorted by category using standard Java sorting utilities.</p>
 *
 * <p>New categories should extend this class and implement {@link #getName()}
 * and {@link #getSortOrder()}.</p>
 */
public abstract class Category implements Comparable<Category> {

    private static final Logger logger = LoggerUtil.getLogger(Category.class);

    /**
     * Returns {@code true} if the given string maps to a known category.
     *
     * <p>Used by {@link seedu.duke.CommandHandler} to validate user input
     * before calling {@link #fromString}, since {@code fromString} defaults
     * to {@link OtherCategory} for unrecognised input rather than throwing.</p>
     *
     * @param categoryString The string to check. Must not be null.
     * @return {@code true} if the input matches a known category name.
     */
    public static boolean isValid(String categoryString) {
        assert categoryString != null : "Category input string must not be null";
        return switch (categoryString.toUpperCase()) {
            case "FOOD", "TRANSPORT", "ENTERTAINMENT", "UTILITIES", "OTHER" -> true;
            default -> false;
        };
    }

    /**
     * Returns the display name of this category in uppercase.
     *
     * <p>This value is used for display output and file persistence.
     * It must be consistent with the keys recognised by {@link #fromString}.</p>
     *
     * @return The uppercase name of this category (e.g., {@code "FOOD"}).
     */
    public abstract String getName();

    /**
     * Returns the sort priority of this category.
     *
     * <p>Lower values appear first when expenses are sorted by category.
     * Each concrete subclass should return a unique positive integer.</p>
     *
     * @return A positive integer representing sort order.
     */
    public abstract int getSortOrder();

    /**
     * Compares this category to another by sort order.
     *
     * @param other The category to compare against.
     * @return A negative integer, zero, or positive integer if this category's
     *         sort order is less than, equal to, or greater than {@code other}'s.
     */
    @Override
    public int compareTo(Category other) {
        assert other != null : "Cannot compare against a null category";

        return Integer.compare(this.getSortOrder(), other.getSortOrder());
    }

    /**
     * Returns the name of this category as its string representation.
     *
     * @return The result of {@link #getName()}.
     */
    @Override
    public String toString() { return getName(); }

    /**
     * Returns a {@code Category} instance corresponding to the given string.
     *
     * <p>Matching is case-insensitive. If the input does not match a recognised
     * category, an {@link IllegalArgumentException} is thrown. Callers should
     * validate input using {@link #isValid} before calling this method.</p>
     *
     * <p>Recognised values: {@code FOOD}, {@code TRANSPORT},
     * {@code ENTERTAINMENT}, {@code UTILITIES}, {@code OTHER}.</p>
     *
     * @param input The string to parse. Must not be null.
     * @return The matching {@code Category} instance.
     * @throws IllegalArgumentException If the input does not match a recognised category.
     */
    public static Category fromString(String input) {
        assert input != null : "Category input string must not be null";

        Category result = switch (input.toUpperCase()) {
            case "FOOD" -> new FoodCategory();
            case "TRANSPORT" -> new TransportCategory();
            case "ENTERTAINMENT" -> new EntertainmentCategory();
            case "UTILITIES" -> new UtilitiesCategory();
            case "OTHER" -> new OtherCategory();
            default -> throw new IllegalArgumentException(
                    "Unknown category: " + input);
        };

        logger.fine("fromString succeeded | input: " + input + " -> " + result.getName());
        return result;
    }

}
