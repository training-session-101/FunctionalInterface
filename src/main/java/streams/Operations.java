package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    public static void main(String[] args) {
        List<Dish> dishes=Arrays.asList(
                new Dish("Biryani",400,200),
                new Dish("Rice",200,250),
                new Dish("Fish Fry",110,300),
                new Dish("Paneer",350,100));

        Map<String,Integer> result=dishes.stream().filter(x-> x.getCalorie() >100).distinct().sorted(Comparator.comparing(Dish::getName)).limit(3).collect(Collectors.toMap(Dish::getName,Dish::getPrice));

        for(Map.Entry<String,Integer> entry:result.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //Dish with the highest calorie
        System.out.println("Rich Food!");
        dishes.stream().sorted(Comparator.comparing(Dish::getCalorie).reversed()).limit(1).findAny().ifPresent(x-> System.out.println(x.getName()));

        //Find length of all the dish names
        System.out.println("Length of all the dishes");
        List<Integer> dishLength=dishes.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());

        dishLength.stream().forEach(System.out::println);

    }
}
