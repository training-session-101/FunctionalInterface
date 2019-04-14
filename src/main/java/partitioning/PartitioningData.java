package partitioning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;

public class PartitioningData {
    List<Dish> dishes;

    public static void main(String[] args) {
            PartitioningData partitioningData = new PartitioningData();
            partitioningData.createDishListWithType();
            partitioningData.partitionByDishType();
            //partitioningData.partitionByDishType();
            partitioningData.printPrimeAndNonPrimeNumbers(10);
    }

    private void createDishListWithType() {
        dishes = Arrays.asList(new Dish("Paneer Fry", 200, "Veg"), new Dish("Biryani", 150, "Non Veg"),
                new Dish("Rice", 150, "Veg"), new Dish("Fish Fry", 350, "Non Veg")).stream().collect(Collectors.toList());
    }


    /*private void partitionByDishType(){
        Map<Boolean,List<Dish>> dishesByType = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("Vegetarian Foods");
        dishesByType.get(true).forEach(dish -> {
            System.out.println(dish.getName());
        });

        System.out.println("Non Vegetarian Foods");
        dishesByType.get(false).forEach(dish -> {
            System.out.println(dish.getName());
        });
    }*/


    private void partitionByDishType(){
        Map<Boolean, Set<String>> dishesBytype = dishes.stream().collect(partitioningBy(Dish::isVegetarian,mapping(Dish::getName, Collectors.toSet())));
        dishesBytype.get(true).forEach(dish -> System.out.println(dish));
    }

    private Boolean isPrimeNumber(int candidate){
        return IntStream.range(2, candidate).noneMatch(i->  candidate%i == 0);
    }

    private void printPrimeAndNonPrimeNumbers(int limit){
        Map<Boolean, List<Integer>> primeNumberPartition= IntStream.rangeClosed(2,limit).boxed().collect(partitioningBy(candidate-> isPrimeNumber(candidate)));
        List<Integer> primeNumbers= primeNumberPartition.get(true);
        System.out.println("Prime Numbers");
        primeNumbers.forEach(x-> System.out.println(x));

        List<Integer> nonPrimeNumbers = primeNumberPartition.get(false);
        System.out.println("Non Prime Numbers");
        nonPrimeNumbers.forEach(x-> System.out.println(x));
    }
}
