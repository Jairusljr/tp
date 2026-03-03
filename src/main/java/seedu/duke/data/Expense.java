package seedu.duke.data;

import seedu.duke.categories.Category;
import java.math.BigDecimal;

/**
 * Represents an individual financial expense within the FinTrackPro system.
 * * <p>Each expense maintains a monetary amount and an associated category string.
 * It implements the {@link Category} interface to provide a visual icon representation.</p>
 */
public class Expense implements Category{

    private final BigDecimal amount;
    private String category;

    /**
     * Constructs a new {@code Expense} with the specified amount.
     * The default category is set to "OTHER".
     *
     * @param amount The monetary value of the expense.
     */
    public Expense(BigDecimal amount) {
        this.amount = amount;
        this.category = "OTHER";
    }

    /**
     * Gets the monetary amount of this expense.
     *
     * @return The expense amount as a {@code BigDecimal}.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Updates the category of this expense and converts it to uppercase.
     *
     * @param category The new category name (e.g., "Food", "Transport").
     */
    public void setCategory(String category) {
        this.category = category.toUpperCase();
    }

    /**
     * Gets the current category assigned to this expense.
     *
     * @return The uppercase category name.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns a visual icon representing the expense category.
     * @return The first letter of the category name as a String.
     */
    @Override
    public String getTypeIcon() {
        return category.substring(0, 1); // First letter of category
    }

    /**
     * Returns a string representation of the expense, including amount and category.
     *
     * @return A formatted string (e.g., "$10.50 [FOOD]").
     */
    @Override
    public String toString() {
        return "$" + amount + " [" + category + "]";
    }

}
