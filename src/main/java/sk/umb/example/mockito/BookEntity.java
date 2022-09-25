package sk.umb.example.mockito;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookEntity {
    private Long id;
    private String title;
    private String author;
}
