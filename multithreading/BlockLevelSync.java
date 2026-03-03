package multithreading;


class Counter2 {
    private int count = 0;
    private final Object lock = new Object();

    public void increment(){
        synchronized (lock){
            count++;
        }
    }

    public int getCount() {
        synchronized (lock){
            return count;
        }
    }
}
public class BlockLevelSync {
    public static void main(String[] args) throws InterruptedException {

        Counter2 obj = new Counter2();

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                obj.increment();
            }
            System.out.println("T1 " + obj.getCount());
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                obj.increment();
            }
            System.out.println("T2 " + obj.getCount());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + obj.getCount());
    }
}
