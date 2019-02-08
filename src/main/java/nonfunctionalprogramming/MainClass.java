package nonfunctionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainClass {
    public static void main(String[] args) {
        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple("Green",120));
        apples.add(new Apple("Red",345));

        // Non Functional Programming
        // new MainClass().filter(apples,new AppleGreenColorPredicate());

        // Passing Behaviour
        // new MainClass().filter(apples,(Apple apple)->"Green".equalsIgnoreCase(apple.getColor()));

    }

    public void filter(List<Apple> apples,ApplePredicate applePredicate){
        for(Apple apple: apples){
            if(applePredicate.test(apple)){
                System.out.println(apple);
            }
        }
    }


    //Using Pre-defined Predicate
    public void filter(List<Apple> apples, Predicate<Apple> predicate){
        for(Apple apple: apples){
            if(predicate.test(apple)){
                System.out.println(apple);
            }
        }
    }


}
