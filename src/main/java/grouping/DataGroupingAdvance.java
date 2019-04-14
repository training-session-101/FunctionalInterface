package grouping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DataGroupingAdvance {
    private List<Dish> dishes;

    public static void main(String[] args) {
        DataGroupingAdvance dataGroupingAdvance = new DataGroupingAdvance();
        //dataGroupingAdvance.createDishList();
        dataGroupingAdvance.createDishListWithType();
        dataGroupingAdvance.printDishByCalorieType();
        dataGroupingAdvance.printDishByTypeCalorie();
        dataGroupingAdvance.printDishWithMaxCalorieAndType();
        dataGroupingAdvance.printDishesBytype();
    }

    private void createDishList() {
        dishes = Arrays.asList(new Dish("Paneer Fry", 150), new Dish("Biryani", 250),
                new Dish("Rice", 150)).stream().collect(Collectors.toList());
    }


    private void createDishListWithType() {
        dishes = Stream.of(new Dish("Paneer Fry", 200, "Veg"), new Dish("Biryani", 150, "Non Veg"),
                new Dish("Rice", 150, "Veg"), new Dish("Fish Fry", 350, "Non Veg")).collect(Collectors.toList());
    }

    private void printMap(Map<String, Map<Dish.CALORIE_TYPE, List<Dish>>> dishesByTypeAndCalorie) {
        dishesByTypeAndCalorie.forEach((type, dishWithCalorie) -> {
            System.out.println("Food Type - "+type);
            dishWithCalorie.forEach((calorieType, dish) -> {
                System.out.print(" Calorie Type - "+ calorieType);
                dish.forEach(x -> System.out.print("\t Food - " +x.getName()));
                System.out.println();
            });
            System.out.println();
        });
    }
    private void printDishByCalorieType() {
        Map<Dish.CALORIE_TYPE, List<Dish>> dishesByCalorieType = dishes.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() < 100)
                return Dish.CALORIE_TYPE.LOW;
            else if (dish.getCalories() >= 100 && dish.getCalories() < 200)
                return Dish.CALORIE_TYPE.MEDIUM;
            else
                return Dish.CALORIE_TYPE.HIGH;
        }));
        dishesByCalorieType.forEach((calorieType, dishes) -> {
            System.out.print(calorieType + " - ");
            dishes.forEach(x -> System.out.println(x.getName()));
        });
    }

    //Multilevel Grouping
    private void printDishByTypeCalorie() {
        Map<String, Map<Dish.CALORIE_TYPE, List<Dish>>> dishesByTypeAndCalorie = dishes.stream().collect(groupingBy(Dish::getDishType, groupingBy((Dish dish) -> {
            if (dish.getCalories() < 100)
                return Dish.CALORIE_TYPE.LOW;
            else if (dish.getCalories() >= 100 && dish.getCalories() < 200)
                return Dish.CALORIE_TYPE.MEDIUM;
            else
                return Dish.CALORIE_TYPE.HIGH;
        })));
        printMap(dishesByTypeAndCalorie);
    }


    //Grouping By Max Calories
    private void printDishWithMaxCalorieAndType(){
        Map<String, Optional<Dish>> dishesByTypeWithMaxCalorie = dishes.stream().collect(groupingBy(Dish::getDishType, Collectors.maxBy(Comparator.comparingDouble(Dish::getCalories))));
        dishesByTypeWithMaxCalorie.forEach((dishType, dish) ->{
            System.out.println("Dish Type is -- "+ dishType);
            dish.ifPresent(dish1 -> System.out.println("Dish Name is -"+ dish1.getName()));
        });
    }

    //Grouping By DishType and DishName
    private void printDishesBytype(){
        Map<Integer,List<String>> dishesByCalorie = dishes.stream().collect(groupingBy(Dish::getCalories, mapping(Dish::getName, toCollection(ArrayList::new))));
        dishesByCalorie.forEach((calorie,dishes) -> {
            System.out.println(calorie);
            dishes.forEach(dish -> System.out.println(dish));
        });
    }
}
