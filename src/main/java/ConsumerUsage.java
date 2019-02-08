import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerUsage {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("A","B","C");
        new ConsumerUsage().print(list,(List<String> l)->{
            for(String s:list){
                System.out.println("Data---"+s);
            }
        });
    }

    void print(List<String>  list,Consumer<List<String>> consumer){
        consumer.accept(list);
    }

}
