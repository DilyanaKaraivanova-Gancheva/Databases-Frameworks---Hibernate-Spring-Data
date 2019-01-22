package Exercises.h_BookLibrary08;

import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    private Map<String,Double> moneyByAuthor;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.moneyByAuthor = new TreeMap<>();
    }

    public void addBook(Book book){
        this.books.add(book);
        this.moneyByAuthor.putIfAbsent(book.getAuthor(), 0d);
        this.moneyByAuthor.put(book.getAuthor(), this.moneyByAuthor.get(book.getAuthor())+book.getPrice());
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(this.books);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.moneyByAuthor.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(),o1.getValue()))
        .forEach(e -> {
                String output = String.format("%s -> %.2f%n",e.getKey(),e.getValue());
                sb.append(output);
    });
        return sb.toString().trim();
    }
}
