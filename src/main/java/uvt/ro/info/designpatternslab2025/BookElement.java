package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor
public class BookElement implements Element, Cloneable {

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public void print() {

    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public Element clone() {
        return null;
    }

}
