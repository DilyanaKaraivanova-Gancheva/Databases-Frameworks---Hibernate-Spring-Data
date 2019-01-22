package i_Animals09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

         String type = bf.readLine();

        while (!type.equalsIgnoreCase("Beast!")){
            String[] line = bf.readLine().split("\\s+");
            try {
                String name = line[0];
                int age = Integer.parseInt(line[1]);
                String gender = line[2];

                Animal animal;
                switch (type) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, "Female");
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, "Male");
                        break;
                    default:
                        throw new IllegalArgumentException(Animal.MESSAGE);
                }
                    System.out.println(animal);


            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
            type = bf.readLine();
        }
    }
}
