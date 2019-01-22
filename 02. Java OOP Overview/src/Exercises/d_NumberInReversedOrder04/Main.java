package Exercises.d_NumberInReversedOrder04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();

        DecimalNumber dn = new DecimalNumber(number);
        dn.printDigits();
    }
}
