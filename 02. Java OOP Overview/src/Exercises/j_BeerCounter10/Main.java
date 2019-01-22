package Exercises.j_BeerCounter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");

        try {
            while (!line[0].equalsIgnoreCase("end")) {
                int bought = Integer.parseInt(line[0]);
                int drank = Integer.parseInt(line[1]);

                BeerCounter.buyBeer(bought);
                BeerCounter.drinkBeer(drank);
                line = bf.readLine().split("\\s+");
            }
        }catch (Exception ignored){}
        finally {
            System.out.printf("%d %d", BeerCounter.beerInStock-BeerCounter.beersDrankCount,BeerCounter.beersDrankCount);
        }


    }
}
