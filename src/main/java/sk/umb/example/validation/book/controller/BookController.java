package sk.umb.example.validation.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.umb.example.validation.book.service.BookCreateDto;
import sk.umb.example.validation.book.service.BookResponseDto;
import sk.umb.example.validation.book.service.BookService;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookResponseDto> listAllBooks() {
        return bookService.listAllBooks();
    }

    @PostMapping("/api/books")
    public Long createBook(@RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }
}
