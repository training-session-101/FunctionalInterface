package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class NumberSummation {
    public static void main(String[] args) {
        long n = 1000;
        long[] data = LongStream.rangeClosed(0, n).toArray();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new Summation(data);
        System.out.println(forkJoinPool.invoke(task));
    }

}    class Summation extends RecursiveTask<Long>{

    public Summation(long[] numbers) {
        this(numbers,0,numbers.length);
    }

        private long[]  data;
        private long startIndex;
        private long endIndex;
        private final long MAXSIZE=100;

        public Summation(long[] data, long startIndex, long endIndex) {
            this.data = data;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }


    @Override
        protected Long compute() {
            if(this.data.length <= MAXSIZE){
                return sum();
            }
            else{
                Summation leftSummation=new Summation(data,startIndex,startIndex+endIndex/2);
                leftSummation.fork();
                Summation rightSummation=new Summation(data,startIndex+(endIndex/2),endIndex);
                long rightResult=rightSummation.compute();
                long leftResult=leftSummation.join();
                return leftResult+rightResult;
            }
        }

        public long sum(){
            return LongStream.rangeClosed(startIndex,endIndex).reduce(0L,Long::sum);
        }
    }
