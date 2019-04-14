package matchopertaion;

import streams.Dish;

import java.util.Arrays;
import java.util.List;

public class UsingPredicates {
    public static void main(String[] args) {
        List<streams.Dish> dishes= Arrays.asList(
                new streams.Dish("Biryani",400,200),
                new streams.Dish("Rice",200,250),
                new streams.Dish("Fish Fry",110,300),
                new Dish("Paneer",350,100));

        //use of allmatch
        if(dishes.stream().allMatch(x-> x.getCalorie() > 100)){
            System.out.println("All Dishes are Rich in Calorie");
        }

        //use of nonmatch
        if(dishes.stream().noneMatch(x-> x.getCalorie() > 100)){
            System.out.println("All Dishes are low in Calorie");
        }

        //use of anymatch
        if(dishes.stream().anyMatch(x-> x.getCalorie() > 100)){
            System.out.println("At least one of the dish is Rich in Calorie");
        }

        //find first element which is rich in calorie
        dishes.stream().filter(x-> x.getCalorie()>100).findFirst().ifPresent(x-> System.out.println(x.getName()));

        //find any element which is rich in calorie(using parallel stream here)
        dishes.parallelStream().filter(x-> x.getCalorie()>100).findFirst().ifPresent(x-> System.out.println(x.getName()));
    }
}
