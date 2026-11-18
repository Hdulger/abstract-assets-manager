import java.math.BigDecimal;

public class Cash extends Asset{
    private BigDecimal cashAmount;

    public Cash(String description, String dateAcquired, BigDecimal originalCost, BigDecimal cashAmount) {
        super(description, dateAcquired, originalCost);
        this.cashAmount=cashAmount;
    }
    @Override
    public BigDecimal getValue() {
        return cashAmount;
    }

}
