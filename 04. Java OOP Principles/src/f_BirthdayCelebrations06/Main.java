package f_BirthdayCelebrations06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> list = new ArrayList<>();
        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){

            if (line.length == 5){
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                String id = line[3];
                String birthdate = line[4];
                Birthable citizen = new Citizen(id,name,age,birthdate);
                list.add(citizen);
            }
            else if (line.length == 3){
                if (line[0].equalsIgnoreCase("pet")){
                    String name = line[1];
                    String birthdate = line[2];
                    Birthable pet = new Pet(name,birthdate);
                    list.add(pet);
                }
            }
            line = bf.readLine().split("\\s+");
        }

        String year = bf.readLine();

        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }

    }
}
