package seedu.duke.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BtoCalculator {
    public final BigDecimal totalDownpayment;
    public final BigDecimal yourShare;

    public BtoCalculator(BigDecimal housePrice, BigDecimal ratio) {
        BigDecimal downpayment = housePrice.multiply(new BigDecimal("0.025"));
        BigDecimal legalFees = downpayment.multiply(BigDecimal.valueOf(1.1));
        this.totalDownpayment = downpayment.add(legalFees).setScale(2, RoundingMode.HALF_UP);
        this.yourShare = totalDownpayment.multiply(ratio).setScale(2, RoundingMode.HALF_UP);
    }
}
