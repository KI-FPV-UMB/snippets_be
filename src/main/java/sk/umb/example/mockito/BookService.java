package sk.umb.example.mockito;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final MailService mailService;
    private final BookRepository repository;
    private final BookMapper mapper;

    public Long saveBook(BookDto bookDto) {
        simpleInputValidation(bookDto);

        BookEntity entity = repository.save(mapper.toEntity(bookDto));
        mailService.sendMail("admin@exmaple.com", "New book arrived.", entity.toString());

        return entity.getId();
    }

    public List<BookDto> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private static void simpleInputValidation(BookDto dto) {
        if (   ! StringUtils.hasText(dto.getAuthor())
            || ! StringUtils.hasText(dto.getTitle())) {
            throw new IllegalArgumentException("Author or Title are empty fields");
        }
    }
}
