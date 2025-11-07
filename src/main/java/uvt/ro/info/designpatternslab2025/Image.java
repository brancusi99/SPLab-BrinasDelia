package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Image extends BookElement implements Cloneable {

    private String imageName;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image: " + imageName);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Image clone() {
        return new Image(this.imageName);
    }

}


