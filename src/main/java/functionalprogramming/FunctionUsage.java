package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionUsage {
    public static void main(String[] args) {
        List<Integer> result=FunctionUsage.map(Arrays.asList("A","AB","ABC"), (String s)-> s.length());
        result.forEach(s-> System.out.println(s));

    }
    static <T,R> List<R> map(List<T> list,Function<T,R> function){
        List<R> lengthList=new ArrayList<>();
        list.forEach(s -> lengthList.add(function.apply(s)));
        return lengthList;
    }
}
