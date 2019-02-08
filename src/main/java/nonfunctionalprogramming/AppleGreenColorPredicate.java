package nonfunctionalprogramming;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equalsIgnoreCase("Green");
    }
}
