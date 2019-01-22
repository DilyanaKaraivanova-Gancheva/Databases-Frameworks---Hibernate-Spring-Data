package Exercises.f_ShoppingSpree06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Person> clients = new LinkedHashMap<>();
        Map<String,Product> products = new HashMap<>();

        String[] persons = bf.readLine().split(";");
        for (int i = 0; i < persons.length; i++) {
            String[] currentPerson = persons[i].split("=");
            double amount = Double.parseDouble(currentPerson[1]);
            String name = currentPerson[0];

            try {
                Person person = new Person(name, amount);
                clients.put(name, person);
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        String[] allProducts = bf.readLine().split(";");
        for (int i = 0; i < allProducts.length; i++) {
            String[] currentProduct = allProducts[i].split("=");
            double amount = Double.parseDouble(currentProduct[1]);
            String name = currentProduct[0];

            try {
                Product product = new Product(name,amount);
                products.put(name,product);
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }

        }

        String[] line = bf.readLine().split("\\s+");
        while (!line[0].equalsIgnoreCase("end")){
            String personName = line[0];
            String productName = line[1];

            if (clients.containsKey(personName) && products.containsKey(productName)){
                if (clients.get(personName).getMoney() >= products.get(productName).getCost()){
                    clients.get(personName).addProduct(productName, products.get(productName).getCost());
                    System.out.printf("%s bought %s%n", personName, productName);
                }
                else{
                    System.out.printf("%s can't afford %s%n", personName, productName);
                }
            }

            line = bf.readLine().split("\\s+");
        }
            for (Map.Entry<String, Person> stringPersonEntry : clients.entrySet()) {
                if (stringPersonEntry.getValue().getBagOfProducts().size() < 1) {
                    System.out.printf("%s - Nothing bought%n", stringPersonEntry.getKey());
                } else {
                    System.out.printf("%s - %s%n",
                            stringPersonEntry.getKey(),
                            stringPersonEntry.getValue().getBagOfProducts()
                                    .toString()
                                    .replaceAll("]", "")
                                    .replaceAll("\\[", ""));
                }
            }

    }
}
