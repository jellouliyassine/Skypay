import java.util.ArrayList;

public class Account implements AccountService {

    private  int Sold;
    private ArrayList<Transaction> Transactions = new ArrayList<Transaction>();

    // Getter for transactions
    public ArrayList<Transaction> getTransactions() {
        return Transactions;
    }

    /**
     * Constructor - initializes the account with an initial sold (balance).
     * Throws IllegalArgumentException if the initial sold is negative.
     */
    public Account(int sold) {
        if (sold < 0) {
            throw new IllegalArgumentException("Initial sold cannot be negative!!!");
        }
        Sold = sold;
    }
    // Setter for transactions

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.Transactions = transactions;
    }
    

    

    /**
     * Deposits a positive amount into the account. No try-catch needed here
     * because the method assumes 'amount' is valid integer.
     */
    @Override
    public void deposit(int amount) {
        int newSold=this.Sold + Math.abs(amount);
        Transaction transaction = new Transaction(Math.abs(amount),newSold);
        this.Transactions.add(transaction);
        this.Sold= newSold;

    }

    /**
     * Withdraws the specified amount if there are sufficient funds. Throws
     * IllegalArgumentException if funds are insufficient or if amount is
     * invalid.
     */
    @Override
    public void withdraw(int amount) {
        int newSold=this.Sold - Math.abs(amount);

        if (newSold < 0) {
            throw new IllegalArgumentException("your sold is about :" + this.Sold + " tho does not support this operation !!");
        }
        Transaction transaction = new Transaction(-Math.abs(amount),newSold);
        this.Transactions.add(transaction);
        this.Sold= newSold;
    }

    /**
     * Prints all transactions with their date, amount, and running balance.
     */
    @Override
    public void printStatement() {
        System.out.println("Date        || Amount         || Balance        ");
        for (int i = Transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = Transactions.get(i);
            System.out.println(transaction.getDate() + "  || " + transaction.getAmount() + "           || " + transaction.getBalanceAfterTransaction());
        }
    }


}
