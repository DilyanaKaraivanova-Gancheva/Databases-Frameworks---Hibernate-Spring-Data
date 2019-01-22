package org.bookshop.system.bookshopsystem;

import org.bookshop.system.bookshopsystem.models.entities.Author;
import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.models.entities.Category;
import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;
import org.bookshop.system.bookshopsystem.services.author.AuthorService;
import org.bookshop.system.bookshopsystem.services.book.BookService;
import org.bookshop.system.bookshopsystem.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String AUTHORS_PATH = System.getProperty("user.dir") +
            "/src/main/resources/" + "authors.txt";
    private static final String CATEGORIES_PATH = System.getProperty("user.dir") +
            "/src/main/resources/" + "categories.txt";
    private static final String BOOKS_PATH = System.getProperty("user.dir") +
            "/src/main/resources/" + "books.txt";



    private BookService bookService;
    private AuthorService authorService;
    private CategoryService categoryService;

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
       // initAuthors();
        //initCategories();
       // initBooks();
        //getAllTitlesAfterYear2000();
        //getAllAuthorsBeforeYear1990();
       // getAllAuthorsByTheirBooksCount();
        getAllBooksByAuthorName();

    }

    public void initAuthors() throws IOException {
        BufferedReader booksReader = new BufferedReader(
                new FileReader(AUTHORS_PATH));
        List<Author> authors = new ArrayList<>();
        String line;
        while ((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");
            Author author = new Author(data[0],data[1]);
            authors.add(author);
        }

        this.authorService.save(authors);
    }

    public void initCategories() throws IOException {
        BufferedReader categoriesReader = new BufferedReader(
                new FileReader(CATEGORIES_PATH));
        List<Category> categories = new ArrayList<>();
        String line;
        while ((line = categoriesReader.readLine()) != null){
            if (!line.equalsIgnoreCase("")) {
                Category category = new Category(line);
                categories.add(category);
            }
        }

        this.categoryService.save(categories);
    }

    public void initBooks() throws IOException, ParseException {
        List<Author> authors = this.authorService.getAllAuthors();
        List<Category> categories = this.categoryService.getAll();

        BufferedReader booksReader = new BufferedReader(new FileReader(BOOKS_PATH));
        String line;
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");
            Random random = new Random();
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Category category = categories.get(random.nextInt(categories.size()));
            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.getCategories().add(category);

            this.bookService.save(book);
        }

    }

    public void getAllTitlesAfterYear2000() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2000-12-31");

        System.out.println(this.bookService.allTitlesAfterYear(date));
    }

    public void getAllAuthorsBeforeYear1990() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("1991-01-01");

        List<Author> authors = this.authorService.getAllWithBooksBefore(date);

        authors.forEach(a-> System.out.printf("%s %s%n",a.getFirstName(),a.getLastName()));
    }

    public void getAllAuthorsByTheirBooksCount(){
        List<Author> authors = this.authorService.getAllAuthorsOrderByCountOfBooks();

        authors.forEach(a-> System.out.printf("%s %s %d%n",a.getFirstName(),a.getLastName(),a.getBooks().size()));
    }

    public void getAllBooksByAuthorName(){
        List<Book> books = this.bookService.getAllBooksByName("George","Powell");

        books.forEach(b-> System.out.printf("%s %s %d%n",b.getTitle(),b.getReleaseDate(),b.getCopies()));
    }


}
