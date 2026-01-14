package oopsClasses;

public class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance){
        //validations
        if(holderName == null || holderName.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if(holderName == null || holderName.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    public double deposit(double amount){
        balance = balance + amount;
        return balance;
    }

    public double withdraw(double amount){
        balance = balance - amount;
        return balance;
    }

    public void transfer(BankAccount target, double amount){
        this.balance = this.balance - amount;
        target.balance = target.balance + amount;
        System.out.println("Transferred successfully. Current balance of " + this.getHolderName() + " is " + this.getBalance());
        System.out.println("Amount credited. Current balance of " + target.getHolderName() + " is " + target.getBalance());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
