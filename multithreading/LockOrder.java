package multithreading;

public class LockOrder {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired both lock1 and lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired both lock1 and lock2");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}
