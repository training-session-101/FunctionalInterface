package matchopertaion;

public class Dish {
    private final String name;
    private final int price;
    private final int calorie;

    public Dish(String name, int price, int calorie) {
        this.name = name;
        this.price = price;
        this.calorie = calorie;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCalorie() {
        return calorie;
    }
}
