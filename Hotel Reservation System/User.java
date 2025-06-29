/**
 * The `User` class in Java represents a user with an ID, balance, and methods to calculate and
 * retrieve the balance.
 */
public class User {
    private  int id;
    private double balance;


    public User(int userId,double  balance) {
        id=userId;
        this.balance = balance;
    }


    public void calculateBalance(double amount){
        this.balance-=amount;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int idUser) {
        id = idUser;
    }
}
