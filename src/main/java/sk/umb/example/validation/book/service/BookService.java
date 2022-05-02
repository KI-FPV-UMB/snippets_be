package sk.umb.example.validation.book.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private static Faker FAKER = new Faker();

    public BookResponseDto getBook(Long bookId) {
        if (bookId != 1) {
            throw new BookServiceException("Book not found");
        }

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(1L);
        responseDto.setAuthor(FAKER.book().author());
        responseDto.setTitle(FAKER.book().title());
        responseDto.setPublisher(FAKER.book().publisher());

        return responseDto;

    }

    public Long createBook(BookCreateDto bookCreateDto) {
        return 2L;
    }
}
