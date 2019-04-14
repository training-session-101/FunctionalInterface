import java.util.function.Function;

public class LambdaTest {
    public static void main(String[] args) {
            LambdaTest lambdaTest = new LambdaTest();
    }
    Integer display(int x,Function<Integer,Integer> function){
        return function.apply((x));
    }
}
