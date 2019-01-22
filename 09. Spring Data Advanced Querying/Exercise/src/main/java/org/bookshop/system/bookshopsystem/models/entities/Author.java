package org.bookshop.system.bookshopsystem.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NamedStoredProcedureQuery(
        name="usp_select_count_of_books_by_author",
        procedureName="usp_select_count_of_books_by_author",
        parameters={
                @StoredProcedureParameter(name="first_name_par", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="last_name_par", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="res", type=Integer.class, mode=ParameterMode.OUT)
        }
)
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
