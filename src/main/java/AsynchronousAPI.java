import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsynchronousAPI {
    public static void main(String[] args) throws  Exception{
        Future<Double> future=new AsynchronousAPI().asynchronousTask("ABC");
        Double price=future.get();
        System.out.println("I am here!!");
        System.out.printf("The Price is --- "+price);
    }
    Future<Double> asynchronousTask(String product) throws InterruptedException{
        CompletableFuture<Double> completableFuture=new CompletableFuture<>();
        new Thread( ()->{
            Double price=new Double(0);
           completableFuture.complete(price);
            try{
                 price= getPrice(product);
                 //throw new RuntimeException();
            }
            catch(Exception e) {
            completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    Double getPrice(String product) throws InterruptedException{
        Thread.sleep(2000L);
        return 10*Math.random();
    }

}
