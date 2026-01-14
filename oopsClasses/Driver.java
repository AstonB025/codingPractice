package oopsClasses;

public class Driver {
    public static void main(String[] args) {



        BankAccount sender = new BankAccount(1001, "Alex", 1000);
        BankAccount receiver = new BankAccount(1002, "Brian", 0);

        sender.transfer(receiver, 1000);


    }
}