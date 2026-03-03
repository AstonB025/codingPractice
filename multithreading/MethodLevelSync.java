package multithreading;

/*
* 1.A counter class
    increment() method — synchronized
    Two threads both incrementing 1000 times
*
* 2.Same counter
    But only the counter++ line is synchronized
    Not the whole method
*
* 3. Static counter
    Static synchronized method
    Two threads incrementing
*
* */

class Counter1 {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount(){
        return count;
    }
}

public class MethodLevelSync {
    public static void main(String[] args) throws InterruptedException {

        Counter1 obj = new Counter1();

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                obj.increment();
            }
            System.out.println(Thread.currentThread().getName() + " " + obj.getCount());
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=1000; i++){
                obj.increment();
            }
            System.out.println(Thread.currentThread().getName() + " " + obj.getCount());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count : " + obj.getCount());
    }
}
