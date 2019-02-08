import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureUsage {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<String> future=executorService.submit(()-> {
            Thread.sleep(5000L);
          return  "Sunny";

        });

        Future<String> future1=executorService.submit(()-> {
            Thread.sleep(1000L);
            return  "Iftekhar";

        });

        String s=future.get(21, TimeUnit.SECONDS);
        System.out.printf("Data----"+s);
        String s1=future1.get(21, TimeUnit.SECONDS);
        System.out.println("Hello Iftekhar");

        System.out.printf("Data1----"+s1);

    }
}
