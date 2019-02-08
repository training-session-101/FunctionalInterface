package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BiFunctionUsage {
    public static void main(String[] args) {
        List<String> list1= Arrays.asList("A","B","C");
        List<String> list2= Arrays.asList("D","E","F");
        List<String> r=new BiFunctionUsage().print(list1,list2,(List<String> list11, List<String> list21)-> {
            List<String> result=new ArrayList<>();
            for(int i=0;i<list1.size();i++){
                result.add(list1.get(i).concat(list2.get(i)));
            }
            return result;
        });
        r.forEach(s-> System.out.println("Data is "+s));
    }
    List<String> print(List<String> list1, List<String> list2, BiFunction<List<String>,List<String>,List<String>> biFunction){
        return biFunction.apply(list1,list2);
    }
}
