package wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static wallet.CurrencyNote.dollarNote;
import static wallet.CurrencyNote.rupeeNote;
import static wallet.CurrencyUnit.DOLLAR;
import static wallet.CurrencyUnit.RUPEE;

public class WalletTest {
    @Test
    void shouldNotBeAbleToWithdrawMoneyFromEmptyWallet() {
        Wallet wallet = new Wallet();
        CurrencyNote noteRequired = rupeeNote(50);

        boolean isWithdrawSuccessful = wallet.withdrawMoney(noteRequired);

        assertFalse(isWithdrawSuccessful);
    }

    @Test
    void shouldBeAbleToWithdrawMoneyFromWalletWhenAmountIsAvailable() {
        Wallet wallet = new Wallet();
        CurrencyNote rupeeNote = rupeeNote(50);
        wallet.addMoney(rupeeNote);
        CurrencyNote noteRequired = rupeeNote(50);

        boolean isWithdrawSuccessful = wallet.withdrawMoney(noteRequired);

        assertTrue(isWithdrawSuccessful);
    }

    @Test
    void shouldNotBeAbleToWithdrawMoneyFromWalletWhenAmountIsNotAvailable() {
        Wallet wallet = new Wallet();
        CurrencyNote rupeeNote = rupeeNote(100);
        wallet.addMoney(rupeeNote);
        CurrencyNote noteRequired = rupeeNote(200);

        boolean isWithdrawSuccessful = wallet.withdrawMoney(noteRequired);

        assertFalse(isWithdrawSuccessful);
    }

    @Test
    void testTotalMoneyInWalletInRupees() {
        Wallet wallet = new Wallet();
        CurrencyNote rupeeNote = rupeeNote(50);
        CurrencyNote dollarNote = dollarNote(1);
        wallet.addMoney(rupeeNote);
        wallet.addMoney(dollarNote);

        double total = wallet.balance(RUPEE);

        assertEquals(123.00, total);
    }

    @Test
    void testTotalMoneyInWalletInDollars() {
        Wallet wallet = new Wallet();
        CurrencyNote rupeeNote = rupeeNote(73.0);
        CurrencyNote dollarNote = dollarNote(1.0);
        wallet.addMoney(rupeeNote);
        wallet.addMoney(dollarNote);

        double total = wallet.balance(DOLLAR);

        assertEquals(2.0, total);
    }

    @Test
    void shouldBeAbleToAddMoneyToWallet() {
        Wallet wallet = new Wallet();
        CurrencyNote rupeeNote = rupeeNote(50);

        boolean isNoteAdded = wallet.addMoney(rupeeNote);

        assertTrue(isNoteAdded);
    }
}
