package uvt.info.ro.commands;

import uvt.info.ro.services.BooksService;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.List;
import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long bookId;

    public GetBookByIdCommand(BooksService booksService, Long bookId) {
        this.booksService = booksService;
        this.bookId = bookId;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.getBookById(bookId);
    }
}
