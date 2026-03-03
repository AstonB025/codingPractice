package multithreading;

public class WithoutVolatile {

    private static boolean running = true;  // NOT volatile — threads may cache this locally

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int count = 0;
            while(running){   // reads from local CPU cache
                count++;
            }
            System.out.println("T1 Stopped. Count is " + count);
        });

        Thread t2 = new Thread(() -> {
            int count = 0;
            while(running){  // reads from local CPU cache
                count++;
            }
            System.out.println("T2 Stopped. Count is " + count);
        });

        t1.start();
        t2.start();

        Thread.sleep(100);
        running = true;
        System.out.println("Main: Set running = false");

    }
}
