package multithreading;


/*
* // 1. Fixed pool — fixed number of threads
Executors.newFixedThreadPool(5);
// Use when: known workload, controlled concurrency

// 2. Cached pool — creates threads as needed
Executors.newCachedThreadPool();
// Use when: many short-lived tasks, variable load

// 3. Single thread — one thread, sequential
Executors.newSingleThreadExecutor();
// Use when: tasks must run in order

// 4. Scheduled — run after delay or periodically
Executors.newScheduledThreadPool(3);
// Use when: cron-like tasks, delayed execution
*
*
*
*executor.shutdown()
→ Finish all submitted tasks
→ Then shutdown gracefully
→ Like "finish your current orders then close"

executor.shutdownNow()
→ Stop immediately
→ Abandon pending tasks
→ Like "drop everything and close NOW"
→ Returns list of tasks that never ran
*
*
*
* */
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

