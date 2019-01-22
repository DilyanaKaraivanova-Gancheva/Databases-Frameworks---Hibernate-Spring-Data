package Exercises.b_AdvertismentMessage02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] phrases = new String [] {
                "Excellent product.",
        "Such a great product.",
        "I always use that product.",
        "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };


        String[] events = new String [] {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.est product of its category.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };

        String[] author = new String [] {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };

        String[] cities = new String [] {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna"
        };
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfMessages = Integer.parseInt(bf.readLine());

        Random rand = new Random();

        for (int i = 0; i < numberOfMessages; i++) {
            System.out.printf("%s %s %s – %s.%n",phrases[rand.nextInt(phrases.length)],events[rand.nextInt(events.length)],
                    author[rand.nextInt(author.length)],cities[rand.nextInt(cities.length)]);
        }

}
}
