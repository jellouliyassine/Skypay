public class Main {
    public static void main(String[] args) {
        System.out.println("Banking Service -  Test ");

        // Create an account with initial balance 0
        Account account = new Account(0);


        // Perform operations
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Print final statement
        account.printStatement();
    }
}
