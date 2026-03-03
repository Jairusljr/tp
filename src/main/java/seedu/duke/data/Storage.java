package seedu.duke.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Handles the persistence of user profile data and expense lists to a local file.
 */
public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the current financial state to a text file.
     * Format:
     * P | salary | savings | goal | btoGoal | ratio
     * E | amount | category
     */
    public void save(Profile profile, ExpenseList expenseList) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        // Save Profile (P)
        fw.write(String.format("P | %s | %s | %s | %s | %s | %s%n",
                profile.getName(),
                profile.getMonthlySalary(),
                profile.getCurrentSavings(),
                profile.getSpendingGoal(),
                profile.getBtoGoal(),
                profile.getContributionRatio()));

        // Save Expenses (E)
        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            fw.write(String.format("E | %s | %s%n",
                    e.getAmount(),
                    e.getCategory()));
        }

        fw.close();
    }

    /**
     * Loads financial data from the save file into the provided profile and expense list.
     */
    public void load(Profile profile, ExpenseList expenseList) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            return; // No save file yet, start with fresh data
        }

        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] parts = line.split(" \\| ");

            if (parts[0].equals("P")) {
                profile.setName(parts[1]);
                profile.setMonthlySalary(new BigDecimal(parts[2]));
                profile.setCurrentSavings(new BigDecimal(parts[3]));
                profile.setSpendingGoal(new BigDecimal(parts[4]));
                profile.setBtoGoal(new BigDecimal(parts[5]));
                profile.setContributionRatio(new BigDecimal(parts[6]));
            } else if (parts[0].equals("E")) {
                expenseList.add(new BigDecimal(parts[1]));
                expenseList.get(expenseList.size() - 1).setCategory(parts[2]);
            }
        }
        s.close();
    }
}