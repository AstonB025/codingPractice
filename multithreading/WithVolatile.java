package multithreading;

public class WithVolatile {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int count = 0;
            while(running){
                count++;
            }
            System.out.println("T1 Stopped. Count is " + count);
        });

        Thread t2 = new Thread(() -> {
            int count = 0;
            while(running){
                count++;
            }
            System.out.println("T2 Stopped. Count is " + count);
        });

        t1.start();
        t2.start();

        Thread.sleep(100);

        running = false;
        System.out.println("Main: Set running = false");
    }
}



    // volatile does NOT fix this
  //  private static volatile int counter = 0;
// counter++;   // TWO writers → race condition still exists

// Because counter++ = read + increment + write
// Another thread can jump between these steps
// Use AtomicInteger for this instead