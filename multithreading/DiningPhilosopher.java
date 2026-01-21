package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ChopStick {
    private Lock lock;
    private int num;

    public ChopStick(int num){
        lock = new ReentrantLock();
        this.num = num;
    }

    //methods
    public void pickup(){
        lock.lock();
    }

    public void putdown(){
         lock.unlock();
    }

    public int getNum(){
        return num;
    }
}
public class DiningPhilosopher extends Thread{
    private int bites = 10;
    private ChopStick lower, higher;
    private int index;

    public DiningPhilosopher(int i, ChopStick left, ChopStick right){
      index = i;
      if(left.getNum() < right.getNum()){
          this.lower = left;
          this.higher = right;
      } else {
          this.lower = right;
          this.higher = left;
      }
    }

    public void pickup(){
        lower.pickup();
        higher.pickup();
    }

    public void eat(){
        pickup();
        chew();
        putdown();
    }

    public void chew(){
        System.out.println(Thread.currentThread().getName() + " is chewing");
        try {
            Thread.sleep(10); // Simulate eating time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putdown(){
       higher.putdown();
       lower.putdown();
    }


    public void run(){
        for(int i=0; i<bites; i++){
            eat();
        }
    }

}

class Main{
    public static void main(String[] args) {

        ChopStick[] chopSticks = new ChopStick[5];
        for(int i=0; i<5; i++){
            chopSticks[i] = new ChopStick(i);
        }

        DiningPhilosopher[] philosophers = new DiningPhilosopher[5];
        for(int i=0; i<5; i++){

            ChopStick left = chopSticks[i];
            ChopStick right = chopSticks[(i + 1) % 5]; //circular condition

            philosophers[i] = new DiningPhilosopher(i, left, right);
            philosophers[i].setName("philosopher-" + i);
        }

        for(DiningPhilosopher p : philosophers){
            p.start();
        }

        // Wait for all to finish (they won't - deadlock!)
        for(DiningPhilosopher ph : philosophers){
            try {
                ph.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All philosophers finished eating");

    }
}

