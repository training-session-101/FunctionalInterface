package reduce;

import streams.Dish;
import java.util.Arrays;
import java.util.List;

public class ReduceUsage {
    public static void main(String[] args) {
        List<Dish> dishes= Arrays.asList(
                new Dish("Biryani",400,200),
                new Dish("Rice",200,250),
                new Dish("Fish Fry",110,300),
                new Dish("Paneer",350,100));

        Integer calorieSum1=dishes.stream().map(x-> x.getCalorie()).reduce(0,(a,b)-> a+b);
        System.out.println("Sum Of Calories is "+calorieSum1);

        //sum of all the calories of the dishes
        Integer calorieSum=dishes.stream().map(x-> x.getCalorie()).reduce(0,Integer::sum);
        System.out.println("Sum Of Calories is "+calorieSum);

        //Maximum Calories
        Integer maxCalorie=dishes.stream().map(x-> x.getCalorie()).reduce(0,Integer::max);
        System.out.println("Minimum Calories is "+maxCalorie);

        //Minimum Calories
        dishes.stream().map(x-> x.getCalorie()).reduce(Integer::min).ifPresent(x->System.out.println(x));

    }
}
