package Exercises.h_BookLibrary08;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String ISBN;
    private double price;

    public Book(String title, String author, String publisher, String releaseDate, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
