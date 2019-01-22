package g_Mankind07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");


        String[] line2 = bf.readLine().split("\\s+");
        Double weekSalary=Double.parseDouble(line2[2]);
        Double workingHours=Double.parseDouble(line2[3]);

        try {
            Human student = new Student(line[0], line[1], line[2]);
            Human worker = new Worker(line2[0], line2[1], weekSalary, workingHours);
            System.out.println(student);
            System.out.println(worker);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }



    }
}
