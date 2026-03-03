package multithreading;

class Counter3 {
    private static int counter = 0;

    public static synchronized void increment(){
        counter++;
    }

    public static synchronized int getCounter(){
        return counter;
    }
}

public class StaticSynchronized {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                Counter3.increment();
            }
            System.out.println(Thread.currentThread().getName() + " " + Counter3.getCounter());
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                Counter3.increment();
            }
            System.out.println(Thread.currentThread().getName() + " " + Counter3.getCounter());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count " + Counter3.getCounter());
    }
}
