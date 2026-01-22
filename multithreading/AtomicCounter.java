package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.getAndIncrement(); // atomic Operation
    }

    public int getCount(){
        return counter.get();
    }
}

class CounterDriver {
    public static void main(String[] args) {

        AtomicCounter counter = new AtomicCounter();

        Thread[] threads = new Thread[5];

        for(int i=0; i<5; i++){
            threads[i] = new Thread(() -> {
               for(int j=1; j<=1000; j++){
                   counter.increment();
               }
            });
            threads[i].start();
        }

        for(Thread c: threads){
            try{
                c.join();
            } catch(InterruptedException e){
                System.out.println("Error - " + e.getMessage());
            }
        }

        System.out.println("Final count: " + counter.getCount()); // should be 5000
    }
}
