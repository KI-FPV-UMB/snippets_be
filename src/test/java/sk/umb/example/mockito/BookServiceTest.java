package sk.umb.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private MailService mailService;

    @Test
    public void bookServiceSaveValid() {
        Long generatedId = 1L;
        // --- Setup section
        when(bookRepository.save(any()))
                .thenReturn(new BookEntity().setId(generatedId)
                                            .setAuthor("AUTH")
                                            .setTitle("TITL."));

        BookDto bookToSave = new BookDto().setAuthor("Famous Author")
                                          .setTitle("Unknown title");

        Long id = bookService.saveBook(bookToSave);

        assertEquals(generatedId, id);
        verify(bookRepository, times(1)).save(any());
        verify(mailService, times(1)).sendMail(any(), any(), any());
    }
}