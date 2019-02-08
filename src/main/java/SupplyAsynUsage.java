import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SupplyAsynUsage {
    public static void main(String[] args) {
        List<Shops> shops = Arrays.asList(new Shops("Shop1", "ABC", 12),
                new Shops("Shop1", "ABC", 13),
                new Shops("Shop1", "ABC", 14),
                new Shops("Shop1", "ABC", 15),
                new Shops("Shop1", "ABC", 13),
                new Shops("Shop1", "ABC", 14),
                new Shops("Shop1", "ABC", 15),
                new Shops("Shop1", "ABC", 13),
                new Shops("Shop1", "ABC", 14),
                new Shops("Shop1", "ABC", 15)
                );

        long startTime = System.currentTimeMillis();
        List<Shops> shop=new SupplyAsynUsage().useStreams(shops);
        long endTime = System.currentTimeMillis();
        for(Shops s:shop){
            System.out.println(s.getName()+" "+s.getProduct()+" "+s.getPrice());
        }
        System.out.println("Time Elapsed -- " + (endTime - startTime));
    }

    public List<Shops> useStreams(List<Shops> shops) {
        return shops.parallelStream().map(shop -> getPrice(shop.getName(),shop.getProduct()) ).collect(Collectors.toList());
    }

    Shops getPrice(String shopName,String data) {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            System.out.printf("Exception is --- " + e);
        }
        return new Shops(shopName,data,10);
    }
}
