package h_Vehicle08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(line[1]),Double.parseDouble(line[2]));

        line = bf.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(line[1]),Double.parseDouble(line[2]));

        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            line = bf.readLine().split("\\s+");
            if (line.length != 3){
                continue;
            }
            if (line[0].equalsIgnoreCase("drive")){
                if (line[1].equalsIgnoreCase("car")){
                    System.out.println(car.drive(Double.parseDouble(line[2])));
                }
                else {
                    System.out.println(truck.drive(Double.parseDouble(line[2])));
                }
            }
            else if(line[0].equalsIgnoreCase("refuel")){
                if (line[1].equalsIgnoreCase("car")){
                    car.refuel(Double.parseDouble(line[2]));
                }
                else {
                    truck.refuel(Double.parseDouble(line[2]));
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
