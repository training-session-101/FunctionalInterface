package grouping;

import java.util.*;

import static java.util.stream.Collectors.*;

public class DataGroupingBasic {
    private Collection<Dish> dishes;

    public static void main(String[] args) {
        DataGroupingBasic dataGroupingBasic = new DataGroupingBasic();
        dataGroupingBasic.addDishes();
        dataGroupingBasic.groupByCalorie();
        dataGroupingBasic.groupByCalorieUsingJava8API();
        dataGroupingBasic.printStatistics();
    }

    private void addDishes() {
        dishes = new ArrayList<>(Arrays.asList(new Dish("Paneer Fry", 300), new Dish("Biryani", 250),
                new Dish("Rice", 300)));
    }

    //Prior to java 8
    public void groupByCalorie(){
        Map<Integer,List<Dish>> dishMap=new HashMap<>();
        for (Dish dish:dishes){
            if(dishMap.containsKey(dish.getCalories())) {
                List<Dish> dishes = new ArrayList<>(dishMap.get(dish.getCalories()));
                dishes.add(dish);
                dishMap.put(dish.getCalories(),dishes);
            }
            else
            dishMap.put(dish.getCalories(), Arrays.asList(dish));
        }
        //print data
        printData(dishMap);
    }

   private void groupByCalorieUsingJava8API() {
        Map<Integer, List<Dish>> dishesByCalorie = dishes.stream().collect(groupingBy(Dish::getCalories));
        //print data
        printData(dishesByCalorie);
    }

    private void printData(Map<Integer, List<Dish>> dishMap) {
        dishMap.forEach((calorie,dishes)->{
            System.out.println("Calorie is "+calorie);
            dishes.forEach(dish-> System.out.println(dish.getName()));
        });
    }

    private void printDishWithMostCalorie(){
        Optional<Dish> mostCalorieDish = dishes.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        mostCalorieDish.ifPresent(x-> System.out.println(x.getName()));
    }

    private void printStatistics(){
        IntSummaryStatistics statistics = dishes.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("Sum - "+statistics.getSum() + "       Average - "+statistics.getAverage());
        System.out.println("Max - "+statistics.getMax() + "       Min - "+statistics.getMin());
    }
}
