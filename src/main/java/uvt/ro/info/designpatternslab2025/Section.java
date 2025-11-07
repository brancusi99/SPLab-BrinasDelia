package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(force=true)
public class Section extends BookElement implements Cloneable {

    private String title;
    @OneToMany
    private List<BookElement> elements = new ArrayList<>();
    @Setter
    @Getter
    @Id
    @GeneratedValue
    private Long id;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(BookElement element) {
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
    public Section clone() {
        Section copy = new Section(this.title);
        for (Element e : this.elements) {
            copy.add(e.clone());
        }
        return copy;
    }

}

