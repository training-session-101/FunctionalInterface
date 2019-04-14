package constructorreference;

import chaining.Apple;
import chaining.ChainingData;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ObjectSorting {
    public static void main(String[] args) {
        List<chaining.Apple> apples = new ChainingData().createAppleData(Arrays.asList( 20, 10, 30,20),
                Arrays.asList("Yellow", "Green", "Red","Pink"), Apple::new);
        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        apples.forEach(x->System.out.println(x.getColor()));
    }
}
