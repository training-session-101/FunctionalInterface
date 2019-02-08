package functionalprogramming;

import java.util.function.Supplier;

public class SupplierUsage {
    public static void main(String[] args) {
        String s=new SupplierUsage().getData(()-> "Hello World!");
        System.out.printf("Data --- "+s);
    }
    String getData(Supplier<String> supplier){
        return supplier.get();
    }
}
