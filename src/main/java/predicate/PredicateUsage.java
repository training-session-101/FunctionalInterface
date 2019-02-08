package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateUsage {
    public static void main(String[] args) {
        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple("Green",120));
        apples.add(new Apple("Red",345));
        new PredicateUsage().showData(apples,(Apple a)-> a.getColor().equals("Green"));
    }

    void showData(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result=new ArrayList<>();
        for(Apple a:apples){
            if(predicate.test(a))
                result.add(a);
        }
        for(Apple a:result){
            System.out.println("Data --- "+a.getColor());
        }
    }
}
