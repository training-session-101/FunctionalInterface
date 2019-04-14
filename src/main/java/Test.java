import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    private Double c;
    public static void main(String[] args) {
        List<String> data= Arrays.asList("A","B","BF");
        String d = data.stream().collect(Collectors.joining(","));
        System.out.println(d);
    }

    Double test1(Function<Integer,Double> function,Integer a){
        return function.apply(a);
    }


}
