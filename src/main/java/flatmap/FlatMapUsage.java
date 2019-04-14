package flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapUsage {
    public static void main(String[] args) {
        //Print distinct characters from an array of strings
        String[] words= {"hello","World"};
        List<String> wordsList=Arrays.asList(words);

        List<String> distinceCharacters=wordsList.stream().map(x-> x.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println("Distinct Length of Characters - "+distinceCharacters.size());


        //combine two array elements
        List<Integer> number1=Arrays.asList(1,2,3);
        List<Integer> number2=Arrays.asList(4,5);

        List<int[] > pairs=number1.stream().flatMap(i-> number2.stream().map(j-> new int[]{i,j})).collect(Collectors.toList());

        //pairs.stream().forEach(x-> System.out.println(x[0]+","+x[1]));


    }
}
