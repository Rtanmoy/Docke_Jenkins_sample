package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddUsingExecutorService {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        IntStream.range(1,10).forEach(num->{
                CompletableFuture<Integer> oddCompatitableFeture=CompletableFuture.completedFuture(num).
                        thenApplyAsync( x->{
            if(x % 2 != 0) {
                System.out.println("ThreadName " + Thread.currentThread().getName() + " Value : " + x);
            }
               return num;
                        },executorService);
                oddCompatitableFeture.join();

            CompletableFuture<Integer> evenCompatitableFeture=CompletableFuture.completedFuture(num).
                    thenApplyAsync( x->{
                        if(x % 2 == 0) {
                            System.out.println("ThreadName " + Thread.currentThread().getName() + " Value : " + x);
                        }
                        return num;
                    },executorService);
            oddCompatitableFeture.join();

        } );
executorService.shutdown();
    }
}
