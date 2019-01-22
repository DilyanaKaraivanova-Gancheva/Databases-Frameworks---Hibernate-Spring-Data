package org.bookshop.system.bookshopsystem;

import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;
import org.bookshop.system.bookshopsystem.services.author.AuthorService;
import org.bookshop.system.bookshopsystem.services.book.BookService;
import org.bookshop.system.bookshopsystem.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(BookService bookService,
                         AuthorService authorService,
                         CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {


    }

    public void bookTitlesByAgeRestriction(String input){
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());
        this.bookService.getAllBooksByAgeRestriction(ageRestriction).forEach(System.out::println);
    }

    public void goldenBooks(){
        this.bookService.getAllBooksByEditionTypeAndCopies(EditionType.GOLD,5000)
                .forEach(System.out::println);
    }

    public void booksByPrice(){
        this.bookService.getAllBooksWithPriceBiggerAndLowerThanGiven(BigDecimal.valueOf(40),BigDecimal.valueOf(5))
                .forEach(System.out::println);
    }

    public void reducedBook(String title){
        this.bookService.getAllBooksByTitle(title).forEach(System.out::println);

    }

    public void notReleasedBooks(int year) throws ParseException {
        this.bookService.getAllTitlesByReleaseDateIsYearNot(year)
                .forEach(System.out::println);
    }

    public void booksRealesedBeforeDate(String dateString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = df.parse(dateString);

        this.bookService.getAllBooksReleasedBeforeDate(date)
                .forEach(System.out::println);
    }

    public void authorsSearch(String seq){
        this.authorService.getAllAuthorsNamesWhereFirstNameEndsWith(seq)
                .forEach(System.out::println);
    }

    public void booksSearch(String str){
        this.bookService.getAllBookTitlesWhereContains(str)
                .forEach(System.out::println);
    }

    public void bookTitlesSearch(String str){
        this.bookService.getAllBookTitlesWhereAuthorsLastNameStartsWith(str)
                .forEach(System.out::println);
    }

    public void countOfBooks(int numberOfLetters){
        System.out.println(this.bookService.getCountOfBooksWithTitleLongerThan(numberOfLetters));
    }

    public void totalBookCopies(){
        this.authorService.getAllAuthorsAndCountOfTheirBooksCopies()
                .forEach(System.out::println);
    }

    public void increaseBookCopies(String stringDate, int numOfCopies) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        Date date = df.parse(stringDate);
        int updated = this.bookService.increaseBookCopies(numOfCopies, date);
        int totalNumber = updated * numOfCopies;
        System.out.println(totalNumber);
    }

    public void removeBooks(int copies){
        int deleted = this.bookService.deleteBooksWithCopiesLessThan(copies);
        System.out.printf("%d books were deleted%n",deleted);
    }

    public void storedProcedure(String author_name) throws SQLException {
        String firstName = author_name.split("\\s+")[0];
        String lastName = author_name.split("\\s+")[1];

        int res = this.authorService.getAuthorsBooksCountFromProcedure(firstName, lastName);

        if (res>0) {
            String books = res == 1 ? "book" : "books";
            System.out.printf("%s %s has written %d %s%n", firstName, lastName, res, books);
        }else {
            System.out.printf("%s %s has not written any books yet%n", firstName, lastName);
        }
    }
}
