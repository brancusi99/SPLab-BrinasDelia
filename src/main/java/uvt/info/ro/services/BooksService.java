package uvt.info.ro.services;

import org.springframework.stereotype.Service;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Book> getBooks(){
        System.out.println("SERVICE: getting all books");
        return new ArrayList<>(books.values());
    }

    public Optional<Book> getBookById(long id){
        System.out.println("SERVICE: getting book by id " + id);
        return Optional.ofNullable(books.get(id));
    }

    public Book createBook(Book newBook){
        System.out.println("SERVICE: creating book ");
        long id = idCounter.incrementAndGet();
        newBook.setId(id);
        books.put(id, newBook);
        return newBook;
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        System.out.println("SERVICE: Updating book: " + id);
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }

    public boolean deleteBook(Long id) {
        System.out.println("SERVICE: Deleting book: " + id);
        return books.remove(id) != null;
    }

}
