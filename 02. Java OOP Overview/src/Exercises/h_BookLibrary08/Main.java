package Exercises.h_BookLibrary08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Library library = new Library("My Library");

        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            String[] line = bf.readLine().split("\\s+");

            Book book = new Book(line[0],line[1],line[2],line[3],line[4], Double.parseDouble(line[5]));
            library.addBook(book);
        }

        System.out.println(library);
    }
}
