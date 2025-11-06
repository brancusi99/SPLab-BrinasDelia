package uvt.info.ro.commands;

import uvt.info.ro.services.BooksService;
import uvt.ro.info.designpatternslab2025.Book;

import java.util.List;
import java.util.Optional;

public class GetAllBooksCommand implements Command<List<Book>>{
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getBooks();
    }

}
