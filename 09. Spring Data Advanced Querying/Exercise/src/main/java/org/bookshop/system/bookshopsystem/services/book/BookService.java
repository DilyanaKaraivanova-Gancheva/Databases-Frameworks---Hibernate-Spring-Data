package org.bookshop.system.bookshopsystem.services.book;

import org.bookshop.system.bookshopsystem.models.ReducedBookImpl;
import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookService {
    void save(Book book);
    void save(List<Book> books);
    List<String> allTitlesAfterYear(Date year);
    List<Book> getAllBooksByName(String firstName, String lastName);
    List<String> getAllBooksByAgeRestriction(AgeRestriction ageRestriction);
    List<String> getAllBooksByEditionTypeAndCopies(EditionType editionType,Integer copies);
    List<String> getAllBooksWithPriceBiggerAndLowerThanGiven(BigDecimal biggerPrice, BigDecimal lowerPrice);
    List<String> getAllTitlesByReleaseDateIsYearNot(int year);
    List<String> getAllBooksReleasedBeforeDate(Date date);
    List<String> getAllBookTitlesWhereContains(String str);
    List<String> getAllBookTitlesWhereAuthorsLastNameStartsWith(String str);
    int getCountOfBooksWithTitleLongerThan(int len);
    List<ReducedBookImpl> getAllBooksByTitle(String title);
    int increaseBookCopies(int copies, Date date);
    int deleteBooksWithCopiesLessThan(int copies);
}
