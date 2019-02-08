import java.util.concurrent.*;

public class CompletableFutureUsage {
    public static void main(String[] args) throws Exception {
        //new CompletableFutureUsage().useFuture("ABC");
        Future<Double> future=new CompletableFutureUsage().useCompleteableFuture("DEF");
        System.out.printf("Data -- "+future.get());
    }

    Future<Double> useFuture(String data){
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<Double> future=executorService.submit(()-> getPrice(data));
        return future;
    }


    Future<Double> useCompleteableFuture(String data){
       CompletableFuture<Double> completableFuture=new CompletableFuture();
       new Thread(()-> {
           completableFuture.complete(getPrice(data));
       }).start();
       return completableFuture;
    }



    Double getPrice(String product){
        return 10*Math.random();
    }

}
