package seedu.duke.util;

import seedu.duke.ui.Ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class InputUtil {
    private static final NumberFormat MONEY_FMT =
            NumberFormat.getCurrencyInstance(Locale.US);

    // to make sure that it is always 2dp + comma separator (eg 12,250.00)
    public static String formatMoney(BigDecimal amount) {
        return MONEY_FMT.format(amount);
    }

    public static BigDecimal readMoney(Ui ui, Scanner in, String prompt) {
        while (true) {
            String moneyString = ui.readLine(in,prompt).trim();

            // Only digits, optionally ".digits" (1-2 dp)
            // Allows: "10250", "10250.5", "10250.50"
            // Rejects: "-1", "10,250", "$100", "12.345", "12.", ".50", "12 3", "abc"
            if (!moneyString.matches("\\d+(\\.\\d{1,2})?")) {
                ui.printLine("Bruh I need a valid amount like " +
                        "10250 or 10250.50 (numbers only, max 2 dp). Try again.");
                continue;
            }

            try {
                BigDecimal amount = new BigDecimal(moneyString);

                if (amount.compareTo(BigDecimal.ZERO) < 0) {
                    ui.printLine("The amount cannot be negative. Please try again.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                ui.printLine("Invalid number. Please try again!");
            }
        }
    }

    public static LocalDate readFutureDate(Ui ui, Scanner in, String prompt) {
        while (true) {
            String s = ui.readLine(in, prompt).trim();

            try {
                LocalDate date = LocalDate.parse(s);
                LocalDate today = LocalDate.now();

                if (!date.isAfter(today)) {
                    ui.printLine("Deadline must be a future date. Try again.");
                    continue;
                }

                return date;

            } catch (DateTimeParseException e) {
                ui.printLine("Date format needs to be YYYY-MM-DD (e.g., 2026-12-31). Try again.");
            }
        }
    }
}
