package wallet;

public enum CurrencyUnit {
    RUPEE(1),
    DOLLAR(73);

    double valueInBaseCurrencyUnit;

    CurrencyUnit(double valueInBaseCurrencyUnit) {
        this.valueInBaseCurrencyUnit = valueInBaseCurrencyUnit;
    }

    double convertTo(CurrencyUnit unit) {
        return this.valueInBaseCurrencyUnit / unit.valueInBaseCurrencyUnit;
    }
}
