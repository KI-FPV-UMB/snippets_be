package sk.umb.example.validation.book.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookCreateDto {

    @NotBlank(message = "Title must not be empty.")
    private String title;
    private String publisher;
    private String author;

    @Min(value = 1, message = "Amount must be at least 1.")
    private int amount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
