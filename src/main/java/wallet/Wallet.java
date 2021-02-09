package wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<CurrencyNote> notes;

    public Wallet() {
        notes = new ArrayList<>();
    }

    public boolean withdrawMoney(CurrencyNote amount) {
        for (CurrencyNote note : notes) {
            if (note.equals(amount)) {
                notes.remove(note);
                return true;
            }
        }
        return false;
    }

    public boolean addMoney(CurrencyNote note) {
        return notes.add(note);
    }

    public double balance(CurrencyUnit preferredCurrency) {
        double total = 0;
        for (CurrencyNote note : notes) {
            total += note.getValueInCurrency(preferredCurrency);
        }
        return total;
    }
}
