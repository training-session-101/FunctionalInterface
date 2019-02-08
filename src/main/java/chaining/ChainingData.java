package chaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChainingData {
    public static void main(String[] args) {

        List<Apple> apples=new ChainingData().createAppleData(Arrays.asList(10,20,20,30),
                Arrays.asList("Green","Green","Red","Yellow"),Apple::new);

        //Predicate chaining
        Predicate<Apple> redApple = a-> a.getColor().equals("Red") ;
        List<Apple> redAndHeavyApples=apples.stream().filter(redApple.and(a->a.getWeight()>=20)).collect(Collectors.toList());
        redAndHeavyApples.forEach(a-> System.out.println(a.getColor() +" "+a.getWeight()));

        //Function chaining
        Function<Integer,Integer> function= (a)-> a+1;
        Function<Integer,Integer> multiplyFunction=function.andThen(x->x*2);
        Integer result=multiplyFunction.apply(10);
        System.out.println(result);

        Function<Integer,Integer> composeFunction=function.compose(x->x*2);
        Integer result1 = composeFunction.apply(10);
        System.out.println(result1);

    }

    public List<Apple> createAppleData(List<Integer> weights, List<String> colors,
                                       BiFunction<Integer, String,Apple> function){
        List<Apple> result=new ArrayList<>();
        //IntStream.range(0, weights.size()).forEach(index-> result.add(function.apply(weights.get(index),colors.get(index))));
        for(int i=0;i<weights.size();i++){
         result.add(function.apply(weights.get(i),colors.get(i)));
        }
        return result;
    }
}
