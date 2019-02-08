import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class SupplierUsage {
    public static void main(String[] args) {
        String s=new SupplierUsage().getData(()-> "Hello World!");
        System.out.printf("Data --- "+s);

    }

    String getData(Supplier<String> supplier){
        return supplier.get();
    }

    int data(int a,int b,IntBinaryOperator binaryOperator){
        return binaryOperator.applyAsInt(a,b);
    }
}
