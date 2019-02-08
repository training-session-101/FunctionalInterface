import java.util.stream.Stream;

public class PrintNumber {
    public static void main(String[] args) {
        Stream.iterate(0L,i -> i+1).forEach(System.out::println);
    }
}
