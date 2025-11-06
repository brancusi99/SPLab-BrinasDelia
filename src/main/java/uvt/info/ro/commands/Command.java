package uvt.info.ro.commands;

import uvt.ro.info.designpatternslab2025.Book;

import java.util.Optional;

@FunctionalInterface
public interface Command<T> {
    T execute();
}
