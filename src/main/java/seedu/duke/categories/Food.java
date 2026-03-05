package seedu.duke.categories;

import seedu.duke.data.Expense;

import java.math.BigDecimal;

public class Food extends Expense {
    String category;

    public Food(BigDecimal amount) {
        super(amount);
        this.category = "[FOOD]";
    }

    public String toString() {
        return "You have assigned this expense to " + getCategory();
    }
}
