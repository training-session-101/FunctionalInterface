package grouping;

public class Dish {
    private String name;
    private int calories;
    private String dishType;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Dish(String name, int calories, String dishType) {
        this.name = name;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    enum CALORIE_TYPE{
        LOW,MEDIUM,HIGH;
    }
}
