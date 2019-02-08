package lambda;

import predicate.Predicate;

import java.util.ArrayList;
import java.util.List;

public class MyPredicate<T> {
     List<T> filterApples(List<T> apples, Predicate<T> applePredicate){
        List<T> result=new ArrayList<>();
        for(T a:apples) {
            if (applePredicate.test(a)) {
                result.add(a);
            }
        }
        return result;
    }
}
