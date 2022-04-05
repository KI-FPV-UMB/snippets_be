package sk.umb.example.security.db.book.controller;

import org.springframework.web.bind.annotation.RestController;
import sk.umb.example.security.db.book.service.BookDto;
import sk.umb.example.security.db.book.service.BookService;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CAN_LIST_BOOKS_ROLE
    public List<BookDto> listAllBooks() {
        return Collections.emptyList();
    }

    // CAN_CREATE_BOOKS_ROLE
    public void createBook() {
    }
}
