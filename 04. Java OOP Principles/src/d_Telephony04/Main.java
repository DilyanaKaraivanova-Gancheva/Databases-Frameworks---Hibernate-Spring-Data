package d_Telephony04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = bf.readLine().split("\\s+");
        String[] websites = bf.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone(phoneNumbers, websites);
        System.out.println(smartphone);
    }
}
