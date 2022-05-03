package sk.umb.example.validation.book.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookService {
    private static Faker FAKER = new Faker();
    private static Random RANDOM_NUMBERS = new Random();

    public BookResponseDto getBook(Long bookId) {
        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setAuthor(FAKER.book().author());
        responseDto.setTitle(FAKER.book().title());
        responseDto.setPublisher(FAKER.book().publisher());

        return responseDto;

    }

    public Long createBook(BookCreateDto bookCreateDto) {
        return RANDOM_NUMBERS.nextLong();
    }
}
