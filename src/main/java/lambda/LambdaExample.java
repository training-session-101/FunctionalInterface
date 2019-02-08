package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        Apple a1 = new Apple("Green", 100);
        Apple a2 = new Apple("Red", 78);
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(a1);
        apples.add(a2);

        MyPredicate<Apple> p=new MyPredicate<>();

        List<Apple> result=p.filterApples(apples,(Apple apple)-> "Red".equals(apple.getColor()));

        apples.sort((Apple apple1, Apple apple2) -> apple1.getWeight() - apple2.getWeight());

        for (Apple a : apples) {
            System.out.printf("The Apple is " + a.getColor());
        }

        new LambdaExample().mycode();
    }

    static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple> result=new ArrayList<>();
        for(Apple a:apples) {
            if (applePredicate.test(a)) {
                result.add(a);
            }
        }
        return apples;
    }

    void mycode(){
        Runnable r1 = () -> System.out.println("Hello World!!");
        Thread t11=new Thread(r1);
        t11.start();
    }



}
