package predicate;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
