package uvt.ro.info.designpatternslab2025;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element {

    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    // ✅ metoda nouă cerută de exercițiu
    public void addContent(Element element) {
        elements.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println("\nContent:");
        for (Element e : elements) {
            e.print();
        }
    }

    // metodele din Element
    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
