package org.bookshop.system.bookshopsystem.repositories;

import org.bookshop.system.bookshopsystem.models.ReducedBook;
import org.bookshop.system.bookshopsystem.models.ReducedBookImpl;
import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> getAllByReleaseDateAfter(Date date);

    @Query("SELECT b FROM Book b where b.author.firstName =:firstName and b.author.lastName =:lastName order by " +
            "b.releaseDate DESC, b.title ASC ")
    List<Book> getAllByName(@Param("firstName") String firstName,@Param("lastName") String lastName);

    List<Book> getAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getAllByEditionTypeAndCopiesLessThan(EditionType editionType,Integer copies);

    List<Book> getAllByPriceGreaterThanOrPriceLessThan(BigDecimal biggerPrice, BigDecimal lowerPrice);

    @Query(value = "SELECT b FROM Book b WHERE function('year', b.releaseDate) <> :year")
    List<Book> getAllByReleaseDateYearIsNot(@Param("year")int year);

    List<Book> getAllByReleaseDateBefore(Date date);
    List<Book> getAllByTitleIgnoreCaseContaining(String str);

    List<Book> getAllByAuthorLastNameStartingWith(String str);

    @Query("SELECT b FROM Book as b where length(b.title) > :len")
    List<Book> getAllByTitleLengthLongerThan(@Param("len") int length);

    List<Book> getAllByTitleIs(String title);

    @Query("UPDATE Book as b SET b.copies = b.copies + :addCopies where b.releaseDate > :date")
    @Modifying
    @Transactional
    int increaseBooksCopiesWithGivenNumber(@Param("addCopies")int copies, @Param("date") Date date);

    @Modifying
    @Transactional
    int deleteBookByCopiesLessThan(int copies);
}
