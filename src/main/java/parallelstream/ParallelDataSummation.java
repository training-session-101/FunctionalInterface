package parallelstream;

import java.util.stream.LongStream;

public class ParallelDataSummation {
    public static void main(String[] args) {
        long n=10_000;
        Accumulator accumulator=new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        long result=accumulator.total;
        System.out.println(result);
    }
}
    class Accumulator{
        public long total=0;
        public long add(long value){
            return total+=value;
        }
    }
