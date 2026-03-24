package seedu.duke.data;

import java.util.ArrayList;

public class RecurringExpenseList {

    private final ArrayList<RecurringExpense> recurringExpenses = new ArrayList<>();

    public void add(RecurringExpense recurringExpense) {
        assert recurringExpense != null : "Recurring expense must not be null";
        recurringExpenses.add(recurringExpense);
    }

    public RecurringExpense delete(int indexInList) {
        int indexToDelete = indexInList - 1;
        return recurringExpenses.remove(indexToDelete);
    }

    public RecurringExpense get(int index) {
        return recurringExpenses.get(index);
    }

    public int size() {
        return recurringExpenses.size();
    }

    public boolean isEmpty() {
        return recurringExpenses.isEmpty();
    }

    public boolean isValidIndex(int inputIndex) {
        return inputIndex >= 1 && inputIndex <= recurringExpenses.size();
    }
    public void applyTo(ExpenseList expenseList) {
        assert expenseList != null : "Expense list must not be null";

        for (RecurringExpense recurringExpense : recurringExpenses) {
            assert recurringExpense != null : "Recurring expense in list must not be null";

            expenseList.add(
                    recurringExpense.getName(),
                    recurringExpense.getAmount(),
                    recurringExpense.getCategory()
            );
        }
    }
}
