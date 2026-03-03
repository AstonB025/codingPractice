package multithreading;

import java.util.concurrent.atomic.*;

public class AtomicIntegerExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=10000; i++){
                counter.incrementAndGet();
            }
            System.out.println("T1 - " + counter.get());
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=10000; i++){
                counter.incrementAndGet();
            }
            System.out.println("T2 - " + counter.get());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count value " + counter.get());
    }
}
