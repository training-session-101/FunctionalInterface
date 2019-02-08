package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class NumberSummation {
    public static void main(String[] args) {
        long n = 10_00000;
        long[] data = LongStream.rangeClosed(0, n).toArray();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new Summation(data, 0, data.length - 1);
        System.out.println(forkJoinPool.invoke(task));
    }

}    class Summation extends RecursiveTask<Long>{
        private long[]  data;
        private long startIndex;
        private long endIndex;
        private final long MAXSIZE=10_000;

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
                startIndex=0;
                endIndex=startIndex+data.length/2;
                Summation leftSummation=new Summation(data,startIndex,endIndex);
                leftSummation.fork();

                Summation rightSummation=new Summation(data,endIndex+1,data.length-1);
                long rightResult=rightSummation.compute();

                long leftResult=leftSummation.join();

                //System.out.println("The Final Summation Value is --- "+leftResult+rightResult);
                return leftResult+rightResult;
            }
        }

        public long sum(){
            return LongStream.rangeClosed(startIndex,endIndex).reduce(0L,Long::sum);
        }
    }
