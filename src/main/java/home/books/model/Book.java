package home.books.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    private long id;
    private String name;
    private String isbn;
    private Integer year;
    private String topic;

    public Book() {
    }

    public Book(String name, String isbn, Integer year, String topic) {
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.topic = topic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "isbn", nullable = false, unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
