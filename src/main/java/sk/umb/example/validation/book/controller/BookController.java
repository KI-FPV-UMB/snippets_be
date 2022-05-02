package sk.umb.example.validation.book.controller;

import org.springframework.web.bind.annotation.*;
import sk.umb.example.validation.book.service.BookCreateDto;
import sk.umb.example.validation.book.service.BookResponseDto;
import sk.umb.example.validation.book.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books/{bookId}")
    public BookResponseDto listAllBooks(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/api/books")
    public Long createBook(@Valid @RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }
}
