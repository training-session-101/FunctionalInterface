import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionUsage {
    public static void main(String[] args) {
        List<Integer> result=new FunctionUsage().map(Arrays.asList("A","AB","ABC"), (String s)-> s.length());
        for(Integer i:result){
            System.out.println("Data --- "+i);
        }

    }
    static <T,R> List<R> map(List<T> list,Function<T,R> function){
        List<R> lengthList=new ArrayList<>();
        for(T t:list){
            lengthList.add(function.apply(t));
        }
        return lengthList;
    }
}
