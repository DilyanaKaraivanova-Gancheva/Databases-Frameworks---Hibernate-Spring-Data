package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class a_StudentsByGroup01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> studentsGroup = new HashMap<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            studentsGroup.put(line[0]+" " + line[1],Integer.parseInt(line[2]));

            line = bf.readLine().split("\\s+");
        }

        studentsGroup.entrySet().stream()
                .filter(g -> g.getValue() == 2)
                .sorted(Comparator.comparing(s -> s.getKey().split("\\s+")[0]))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
