package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by HillelNew5 on 15.04.2018.
 */
public class Practice {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(120, 50, 800, 100, 200, 500, 1200, 10, 1500, 2000, 5000, 80);


       /* for(int i =0 ; i < prices.size(); i++){
            System.out.println(prices.get(i));
        }
        for(Integer price : prices){
            System.out.println(price);
        }
        prices.stream().forEach(i ->{System.out.println(i);} );

        prices.stream().forEach(System.out::println);*/

        /*prices.stream().forEach(i ->{
            System.out.println(i);
            System.out.println(i*2);} );
        */
       /* prices.stream().filter(i -> i<400)
        .collect(Collectors.toList())
        .forEach(System.out::println);

        List<String> names = Arrays.asList("Mark", "Vika", "Bogdan", "Dima","Luiza","Alina");

        names.stream()
                .filter(i -> i.length() > 4)
                .forEach(i -> {System.out.println("Name: " + i + ".Amount of characters: " + i.length());});

       names.stream()
               .filter(i -> i.length() > 4)
               .collect(Collectors.toList())
               .forEach(i -> {System.out.println("Name: " + i + ".Amount of characters: " + i.length());});

        List<String> x2 = Arrays.asList("88", "33", "44", "55","Luiza");
        x2.stream().map(i -> Integer.valueOf(1))
                .forEach(i -> System.out.println(i*i));

        x2.stream().map(i -> Integer.valueOf(1))
                .map(i -> i*2)
                .forEach(System.out::println);

        List<Integer> priceTwo = new ArrayList<>();*/

        prices.stream()
                .filter(i -> (i/10) < 100)
                .forEach(System.out::println);

        System.out.println("------------------------------");

        prices.stream()
                .sorted()
                .filter(i -> i > 400)
                .findFirst().ifPresent(i -> System.out.println(i));




    }



}
