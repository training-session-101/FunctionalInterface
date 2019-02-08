package parallelstream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumberSummation {
    public static void main(String[] args) {
        long n=10_000_00000;

        long iterationStartTime=System.currentTimeMillis();
        new NumberSummation().IterativeSummation(n);
        long iterationEndTime=System.currentTimeMillis();
        System.out.println("TimeTaken for iterative summation is ---"+ (iterationEndTime-iterationStartTime) +" milliseconds");


        long rangeClosedStartTime=System.currentTimeMillis();
        new NumberSummation().parallelRangedSum(n);
        long rangeClosedEndTime=System.currentTimeMillis();
        System.out.println("TimeTaken for Range Closed Stream is ---"+ (rangeClosedEndTime-rangeClosedStartTime) +" milliseconds");


        long steamStartTime=System.currentTimeMillis();
        new NumberSummation().sequentialReduction(n);
        long streamEndTime=System.currentTimeMillis();
        System.out.println("TimeTaken for sequential is ---"+ (streamEndTime-steamStartTime) +" milliseconds");

        long parallelSteamStartTime=System.currentTimeMillis();
        new NumberSummation().parallelReduction(n);
        long parallelSteamEndTime=System.currentTimeMillis();
        System.out.println("TimeTaken for parallel reduction  is ---"+ (parallelSteamEndTime-parallelSteamStartTime) +" milliseconds");

        //System.out.println(Runtime.getRuntime().availableProcessors());

    }

    private long IterativeSummation(long n){
        long sum=0L;
        for(long i=0;i<=n;i++)
            sum+=i;
        return sum;
    }

    private long sequentialReduction(long n){
        return LongStream.iterate(0L,i->i+1).limit(n+1).reduce(0L,Long::sum);
    }

    private long parallelRangedSum(long n) {
        return LongStream.rangeClosed(0, n).parallel().reduce(0L, Long::sum);
    }

        private long parallelReduction(long n){
            return Stream.iterate(0L,i->i+1).limit(n+1).unordered().reduce(0L,Long::sum);
        }

}

