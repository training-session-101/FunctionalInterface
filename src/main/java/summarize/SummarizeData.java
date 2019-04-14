package summarize;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizeData {
    List<Dish> dishes;
    public static void main(String[] args) {
        SummarizeData summarizeData = new SummarizeData();
        summarizeData.createDishListWithType();
        summarizeData.printSummarizedData();
    }

        private void createDishListWithType(){
            dishes = Arrays.asList(new Dish("Paneer Fry", 200, "Veg"), new Dish("Biryani", 150, "Non Veg"),
                    new Dish("Rice", 150, "Veg"), new Dish("Fish Fry", 350, "Non Veg")).stream().collect(Collectors.toList());
        }

        private void printSummarizedData(){
            IntSummaryStatistics statistics = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
            System.out.println(statistics);
    }
}
