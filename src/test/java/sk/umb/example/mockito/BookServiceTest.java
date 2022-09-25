package sk.umb.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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

    @Spy
    private BookMapper mapper = new BookMapper();

    @Captor
    private ArgumentCaptor<String> emailBodyCaptor;

    @Test
    public void bookServiceSaveValid() {
        // --- setup
        Long generatedId = 1L;

        BookEntity fakeEntity = new BookEntity().setId(generatedId)
                .setAuthor("Famous Author")
                .setTitle("Unknown title");

        when(bookRepository.save(any(BookEntity.class)))
                .thenReturn(fakeEntity);

        // --- execution
        BookDto bookToSave = new BookDto().setAuthor("Famous Author")
                                          .setTitle("Unknown title");

        Long id = bookService.saveBook(bookToSave);

        // verification
        assertEquals(generatedId, id);
        verify(bookRepository, times(1)).save(any());
        verify(mailService, times(1)).sendMail(any(), any(), emailBodyCaptor.capture());
        assertEquals(fakeEntity.toString() , emailBodyCaptor.getValue());
    }

    @Test
    public void bookServiceSaveFail() {
        // --- execution
        BookDto bookToSave = new BookDto().setAuthor("Famous Author");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bookService.saveBook(bookToSave));
        assertEquals("Author or Title are empty fields", exception.getMessage());

        verify(bookRepository, times(0)).save(any());
        verify(mailService, times(0)).sendMail(any(), any(), any());
    }

    @Test
    public void bookServiceDbFailedWrite() {
        when(bookRepository.save(any(BookEntity.class)))
                           .thenThrow(RuntimeException.class);

        // --- execution
        BookDto bookToSave = new BookDto().setAuthor("Famous Author")
                                          .setTitle("Unknown title");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> bookService.saveBook(bookToSave));

        // verification
        verify(bookRepository, times(1)).save(any());
        verify(mailService, times(0)).sendMail(any(), any(), any());
    }
}