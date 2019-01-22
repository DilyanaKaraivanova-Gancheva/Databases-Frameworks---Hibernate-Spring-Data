package e_BorderControl05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> persons = new ArrayList<>();
        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            if (line.length == 3){
                String name = line[0];
                int age = Integer.parseInt(line[1 ]);
                String id = line[2];
                Identifiable person = new Citizen(id,name,age);
                persons.add(person);
            }
            else if(line.length == 2){
                String model = line[0];
                String id = line[1];
                Identifiable person = new Robot(id,model);
                persons.add(person);
            }
            line = bf.readLine().split("\\s+");
        }

        String fakeId = bf.readLine();

        for (Identifiable person : persons) {
            if (person.getId().endsWith(fakeId)){
                System.out.println(person.getId());
            }
        }
    }
}
