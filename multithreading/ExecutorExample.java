package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=1; i<=10; i++){
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + "executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

        try {
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch(InterruptedException e){
            System.out.println("Error: " + e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
