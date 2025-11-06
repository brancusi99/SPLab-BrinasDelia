package uvt.info.ro.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uvt.info.ro.commands.Command;
import uvt.info.ro.commands.CreateBookCommand;
import uvt.info.ro.commands.GetAllBooksCommand;
import uvt.info.ro.services.BooksService;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public ResponseEntity<?> getBooks() {
        Command<List<Book>> command = new GetAllBooksCommand(booksService);
        List<Book> books = command.execute();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooksById(@PathVariable("id") Long id){
        Optional<Book> book = booksService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        Command<Book> command = new CreateBookCommand(booksService, book);
        Book createdBook = command.execute();
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
        Optional<Book> book = booksService.updateBook(id, updatedBook);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        boolean deleted = booksService.deleteBook(id);
        return deleted ? ResponseEntity.ok("Book deleted")
                : ResponseEntity.notFound().build();
    }


}
