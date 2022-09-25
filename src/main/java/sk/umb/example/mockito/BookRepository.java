package sk.umb.example.mockito;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookRepository {
    private static final AtomicLong SEQUENCE_GENERATOR = new AtomicLong(0);
    private static final List<BookEntity> DATASTORE = Collections.synchronizedList(new ArrayList<>());

    public BookEntity save(BookEntity entityToSave) {
        entityToSave.setId(SEQUENCE_GENERATOR.getAndIncrement());
        DATASTORE.add(entityToSave);
        return entityToSave;
    }

    public List<BookEntity> findAll() {
        return DATASTORE;
    }
}
