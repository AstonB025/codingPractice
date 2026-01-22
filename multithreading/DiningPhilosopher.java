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

