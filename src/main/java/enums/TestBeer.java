package enums;

/**
 * Created by HillelNew5 on 12.04.2018.
 */
public class TestBeer {


    public static void main(String[] args) {

        printBeerType(Beer.values());

       // printBeerAlcohol(Beer.values());
    }







    public static void printBeerType(Beer[] beers){
        System.out.println("Beer      type   alcohol" );
        for(Beer beer : beers){
            System.out.println(beer + " " + beer.getType().getType()+ " " + beer.getAlcoholContent());
        }
    }
   /* public  static void printBeerAlcohol(Beer[] beers){
        System.out.println("Beer      " );
        for(Beer beer : beers){
            System.out.println(beer + " " + beer.getAlcoholContent());
        }
    }*/
}
