package flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctElements {
    public static void main(String[] args) {
        String[] words={"Hello","World"};
        List distinctWords = Arrays.asList(words).stream().map(word -> word.split("")).distinct().collect(Collectors.toList());
        distinctWords.stream().forEach(x-> System.out.print(x));

    }
}
