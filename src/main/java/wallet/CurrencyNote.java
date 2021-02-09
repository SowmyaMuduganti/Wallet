package wallet;

import static wallet.CurrencyUnit.DOLLAR;
import static wallet.CurrencyUnit.RUPEE;

public class CurrencyNote {
    private final double value;
    private final CurrencyUnit unit;

    protected CurrencyNote(double value, CurrencyUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static CurrencyNote rupeeNote(double value) {
        return new CurrencyNote(value, RUPEE);
    }

    public static CurrencyNote dollarNote(double value) {
        return new CurrencyNote(value, DOLLAR);
    }

    public double getValue() {
        return value;
    }

    public double getValueInCurrency(CurrencyUnit currencyUnit) {
        return value * unit.convertTo(currencyUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CurrencyNote))
            return false;
        return this.getValue() == ((CurrencyNote) obj).getValue();
    }
}
