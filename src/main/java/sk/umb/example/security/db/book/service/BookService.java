package sk.umb.example.security.db.book.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.umb.example.security.db.book.dal.BookEntity;
import sk.umb.example.security.db.book.dal.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<BookResponseDto> listAllBooks() {
        List<BookResponseDto> books = new ArrayList<>();

        for ( BookEntity entity : bookRepository.findAll() ) {
            books.add(mapToBookResponseDto(entity));
        }

        return books;
    }

    private BookResponseDto mapToBookResponseDto(BookEntity entity) {
        BookResponseDto bookResponseDto = new BookResponseDto();

        bookResponseDto.setId(entity.getId());
        bookResponseDto.setAuthor(entity.getAuthor());
        bookResponseDto.setTitle(entity.getTitle());
        bookResponseDto.setIsbn(entity.getIsbn());

        return bookResponseDto;
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Long createBook(BookCreateDto bookCreateDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor(bookCreateDto.getAuthor());
        bookEntity.setTitle(bookCreateDto.getTitle());
        bookEntity.setIsbn(bookCreateDto.getIsbn());

        bookRepository.save(bookEntity);

        return bookEntity.getId();
    }
}
