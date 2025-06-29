

import java.time.LocalDate;

public class Transaction {

    private int amount;
    private LocalDate date;
    private int balanceAfterTransaction;

    /**
     * Creates a transaction with the given amount and sets the date to today.
     */
    public Transaction(int amount, int balanceAfterTransaction) {
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = LocalDate.now();
    }
    // Getters and setters

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(int balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

}
