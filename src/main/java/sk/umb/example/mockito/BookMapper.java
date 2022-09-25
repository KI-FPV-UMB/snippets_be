package sk.umb.example.mockito;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookEntity toEntity(BookDto dto) {
        return new BookEntity()
                .setId(dto.getId())
                .setAuthor(dto.getAuthor())
                .setTitle(dto.getTitle());
    }

    public BookDto toDto(BookEntity entity) {
        return new BookDto()
                .setId(entity.getId())
                .setAuthor(entity.getAuthor())
                .setTitle(entity.getTitle());
    }
}
