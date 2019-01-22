package Exercises.j_GroupByGroup10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            String name = line[0] + " " + line[1];
            Integer group = Integer.valueOf(line[2]);
            persons.add(new Person(name,group));

            line = bf.readLine().split("\\s+");
        }

       persons
               .stream()
               .collect(Collectors.groupingBy(Person::getGroup))
               .forEach((key, value) -> {
                   String personNames = value
                           .toString()
                           .replaceAll("\\[", "").replaceAll("]", "");
                   System.out.printf("%d - %s%n", key, personNames);

               });
    }
}
