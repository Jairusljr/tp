package seedu.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.duke.util.BtoCalculator;
import java.math.BigDecimal;

public class BtoCalculatorTest {

    @Test
    public void constructor_validInputs_correctValuesComputed() {
        BtoCalculator calculator = new BtoCalculator(
                new BigDecimal("390000"),
                new BigDecimal("0.6")
        );

        assertEquals(new BigDecimal("20475.00"), calculator.totalDownpayment);
        assertEquals(new BigDecimal("12285.00"), calculator.yourShare);
    }

    @Test
    public void constructor_zeroHousePrice_allZero() {
        BtoCalculator calculator = new BtoCalculator(
                BigDecimal.ZERO,
                new BigDecimal("0.6")
        );

        assertEquals(0, calculator.totalDownpayment.compareTo(BigDecimal.ZERO));
        assertEquals(0, calculator.yourShare.compareTo(BigDecimal.ZERO));
    }

    @Test
    public void constructor_fullRatio_shareEqualsTotalDownpayment() {
        BtoCalculator calculator = new BtoCalculator(
                new BigDecimal("390000"),
                BigDecimal.ONE
        );

        assertEquals(calculator.totalDownpayment, calculator.yourShare);
    }
}
