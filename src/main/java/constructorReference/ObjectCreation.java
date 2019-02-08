package constructorReference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ObjectCreation {
    public static void main(String[] args) {

        //Instantiating object using supplier
        Supplier<Apple> supplier=Apple::new;
        Apple a1=supplier.get();


        //Instantiating object using Function
        Function<String,Apple> function = Apple::new;
        Apple a2= function.apply("Green");
        System.out.println(a2.getColor());


        //Instantiating object using BiFunction
        BiFunction<String,Integer,Apple> biFunction = Apple::new;
        Apple a3= biFunction.apply("Green",100);

    }
}
