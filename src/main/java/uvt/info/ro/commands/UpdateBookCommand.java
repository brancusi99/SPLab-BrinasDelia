package uvt.info.ro.commands;

import uvt.info.ro.services.BooksService;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long bookId;
    private final Book bookData;

    public UpdateBookCommand(BooksService booksService, Long bookId, Book bookData) {
        this.booksService = booksService;
        this.bookId = bookId;
        this.bookData = bookData;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.updateBook(bookId, bookData);
    }
}
