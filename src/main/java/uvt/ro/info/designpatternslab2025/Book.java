package uvt.ro.info.designpatternslab2025;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element, Cloneable {

    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    public void addContent(Element element) {
        elements.add(element.clone());  // ✅ clone content
    }

    @Override
    public void print() {
        System.out.println("\nBook: " + title);

        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }

        System.out.println("\nContent:");
        for (Element e : elements) {
            e.print();
        }
    }

    // Composite methods
    @Override
    public void add(Element element) {
        elements.add(element.clone());
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    @Override
    public Book clone() {
        Book copy = new Book(this.title);

        // authors are not Elements → shallow copy e ok
        copy.authors.addAll(this.authors);

        // deep clone elements
        for (Element e : this.elements) {
            copy.elements.add(e.clone());
        }

        return copy;
    }
}
