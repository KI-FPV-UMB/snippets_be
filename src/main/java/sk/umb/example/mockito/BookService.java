package sk.umb.example.mockito;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final MailService mailService;
    private final BookRepository repository;

    public Long saveBook(BookDto bookDto) {
        BookEntity entity = repository.save(toEntity(bookDto));
        mailService.sendMail("admin@exmaple.com", "New book arrived", bookDto.toString());
        return entity.getId();
    }

    public List<BookDto> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(BookService::toDto)
                .collect(Collectors.toList());
    }

    private static BookEntity toEntity(BookDto dto) {
        return new BookEntity()
                .setId(dto.getId())
                .setAuthor(dto.getAuthor())
                .setTitle(dto.getTitle());
    }

    private static BookDto toDto(BookEntity entity) {
        return new BookDto()
                .setId(entity.getId())
                .setAuthor(entity.getAuthor())
                .setTitle(entity.getTitle());
    }
}
