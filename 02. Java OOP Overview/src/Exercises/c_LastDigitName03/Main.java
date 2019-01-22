package Exercises.c_LastDigitName03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        int numToConvert = input % 10;
        Number number = new Number(numToConvert);

        System.out.println(number.englishName());
    }
}
