package uvt.info.ro.commands;

import uvt.info.ro.services.BooksService;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.Optional;

public class CreateBookCommand implements Command<Book> {

    private final BooksService booksService;
    private final Book bookToCreate;

    public CreateBookCommand(BooksService booksService, Book bookToCreate) {
        this.booksService = booksService;
        this.bookToCreate = bookToCreate;
    }

    @Override
    public Book execute() {
        return booksService.createBook(bookToCreate);
    }
}
