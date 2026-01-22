package multithreading;

public class SafeCounter {
    private int count = 0;

    // Make this method thread-safe using synchronized
    public void increment() {
        synchronized (this){
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class counterDriver{
    public static void main(String[] args) {
        SafeCounter counter = new SafeCounter();

        Thread t1 = new Thread(()-> {
            for(int i=1; i<=1000; i++){
                counter.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i=1; i<=1000; i++){
                counter.increment();
            }
        });

        Thread t3 = new Thread(()-> {
            for(int i=1; i<=1000; i++){
                counter.increment();
            }
        });

        Thread t4 = new Thread(()-> {
            for(int i=1; i<=1000; i++){
                counter.increment();
            }
        });

        Thread t5 = new Thread(()-> {
            for(int i=1; i<=1000; i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch(InterruptedException e){
            System.out.println("Some Error: " + e.getMessage());
        }

        System.out.println("Final count: " + counter.getCount());

    }
}