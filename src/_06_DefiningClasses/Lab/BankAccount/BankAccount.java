package _06_DefiningClasses.Lab.BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int countId = 0;

    public BankAccount() {
        countId++;
        this.id = countId;
    }

    public double getInterestRate(int year) {
        return BankAccount.interestRate * year * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        BankAccount.countId = countId;
    }
}
