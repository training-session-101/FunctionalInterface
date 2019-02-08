package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerUsage {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("A","B","C");
        new ConsumerUsage().print(list,(List<String> l)->{
            list.forEach(x-> System.out.println(x));
        });
    }

    void print(List<String>  list,Consumer<List<String>> consumer){
        consumer.accept(list);
    }

}
