package sk.umb.example.security.db.book.controller;

import org.springframework.web.bind.annotation.RestController;
import sk.umb.example.security.db.book.service.BookService;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
}
