package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(force=true)
public class Book implements Element, Cloneable {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    private List<Author> authors = new ArrayList<>();
    @OneToMany
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    public void addContent(Element element) {
        elements.add(element.clone());
    }

    @Override
    public void print() {
        System.out.println("\nBook: " + title);
        System.out.println("ID: " + id);

        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }

        System.out.println("\nContent:");
        for (Element e : elements) {
            e.print();
        }
    }

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
        copy.setId(this.id);

        copy.authors.addAll(this.authors);

        for (Element e : this.elements) {
            copy.elements.add(e.clone());
        }

        return copy;
    }
}