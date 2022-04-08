package sk.umb.example.security.db.book.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "books")
public class BookEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "author", nullable = false)
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
