package app;

import java.util.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {

        DataRepository provider = new DataRepository();

        Map<String, Double> list = provider.getData().stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));
//                                Collectors.teeing(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))))));

        for (Map.Entry<String, Double> entry : list.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Category - " + key
                    + ", cost USD " + value.doubleValue());
        }
    }
}
