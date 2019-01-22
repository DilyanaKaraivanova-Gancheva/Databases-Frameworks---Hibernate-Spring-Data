package Exercises.j_BeerCounter10;

public class BeerCounter {
    public static int beerInStock;
    public static int beersDrankCount;


    public static void buyBeer(int bootlesCount){
        beerInStock += bootlesCount;
    }

    public static void drinkBeer(int bootlesCount){
        beersDrankCount += bootlesCount;
    }
}
