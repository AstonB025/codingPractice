package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantFlow {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(() -> {
        boolean workDone = false;
        while(!workDone){
            try {
                if(lock1.tryLock(1, TimeUnit.SECONDS)){
                    try {
                        System.out.println(Thread.currentThread().getName() + " acquired lock1");
                        Thread.sleep(100);

                        if(lock2.tryLock(1, TimeUnit.SECONDS)){
                            try {
                                System.out.println(Thread.currentThread().getName() + " acquired both locl1 and lock2");
                                workDone = true;
                            } finally {
                                lock2.unlock();
                                System.out.println(Thread.currentThread().getName() + " released lock2");
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " could not acquire lock2 - backing off");
                            Thread.sleep(50);
                        }
                    } finally {
                        lock1.unlock();
                        System.out.println(Thread.currentThread().getName() + " released lock1");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire lock1 - backing off");
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;   // very imp
            }
        }
    });

    Thread t2 = new Thread(() -> {
        boolean workDone = false;
        while(!workDone){
            try {
                if(lock2.tryLock(1, TimeUnit.SECONDS)){
                    try {
                        System.out.println(Thread.currentThread().getName() + " acquired lock2");
                        Thread.sleep(100);

                        if(lock1.tryLock(1, TimeUnit.SECONDS)){
                            try{
                                System.out.println(Thread.currentThread().getName() + " acquired both lock2 and lock1");
                                workDone = true;
                            } finally {
                                lock1.unlock();
                                System.out.println(Thread.currentThread().getName() + " released lock1");
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " couldn't acquire lock1 - backing off");
                            Thread.sleep(100);
                        }
                    }finally {
                        lock2.unlock();
                        System.out.println(Thread.currentThread().getName() + " released lock2");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " couldn't acquire lock2 - backing off");
                    Thread.sleep(100);
                }
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

        System.out.println("  End of the flow ");



    }
}
