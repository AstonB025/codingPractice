package multithreading;

public class Task1 extends Thread {
    @Override
    public void run(){
        System.out.print("Method-1: ");
        for(int i=1; i<=5; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Task2 implements Runnable {

    @Override
    public void run(){
        System.out.print("Method-2: ");
        for(int i=1; i<=5; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Driver {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        Task2 obj = new Task2();

        Thread task2 = new Thread(obj);
        task1.start();
        task2.start();

    }
}
