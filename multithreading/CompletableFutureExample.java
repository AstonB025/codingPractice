package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> productFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Fetching product on " + Thread.currentThread().getName()); // under the good uses ForkJoinPool
                    return "MacBook";
                });

        CompletableFuture<String> inventoryFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Fetching inventory on " + Thread.currentThread().getName());
                    return "In Stock";
                });

        //Wait for both to complete
        CompletableFuture.allOf(productFuture, inventoryFuture).join();

        String productResult = productFuture.get();
        String inventoryResult = inventoryFuture.get();


    }
}


/*
* /*
* Chaining Example
* CompletableFuture<String> future =
    CompletableFuture.supplyAsync(() -> "macbook pro")
        .thenApply(s -> s.toUpperCase())        // "MACBOOK PRO"
        .thenApply(s -> "Product: " + s)        // "Product: MACBOOK PRO"
        .exceptionally(ex -> "Error occurred"); // fallback
        *
        * */