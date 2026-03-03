package multithreading;

public class Deadlock {
 private static final Object lock1 = new Object();
 private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                    try{
                        Thread.sleep(100);
                    } catch(Exception e){
                        System.out.println(" ___ ");
                    }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    try{
                        Thread.sleep(100);
                    } catch(Exception e){
                        System.out.println(" ___ ");
                    }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                }
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println();

    }
}
