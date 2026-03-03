package multithreading;

//Use ExecutorService with Callable instead of Runnable.
// Submit 5 tasks where each task returns the square of its task number.
// Collect all results and print them.

import java.util.List;
import java.util.List.*;
import java.util.ArrayList;
import java.util.concurrent.*;


/*
* Callable defines a task that returns a value.
* ExecutorService.submit() hands it to a thread pool and immediately returns a Future — a ticket for the result.
*  Collecting all futures first then calling get() ensures all tasks run simultaneously.
* Calling get() inside the submit loop would make execution sequential — defeating the purpose of parallelism.
* */

public class ExecutorCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        //List to store all the futures
        List<Future<Integer>> futures = new ArrayList<>();

        for(int i=1; i<=5; i++){
            int taskNumber = i;

            Callable<Integer> task = () -> {
              int square = taskNumber * taskNumber;
                System.out.println(Thread.currentThread().getName() + " -> Task " + taskNumber + " -> Square " + square );
                return square;
            };
            futures.add(executor.submit(task));
        }

        for(Future<Integer> future : futures){
            System.out.println("Result " + future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}





/*
* future.get()
→ BLOCKS the current thread until result is ready
→ throws ExecutionException if task threw exception
→ throws InterruptedException if thread interrupted

// With timeout — don't wait forever
future.get(5, TimeUnit.SECONDS)
→ throws TimeoutException if not done in 5 seconds
* */