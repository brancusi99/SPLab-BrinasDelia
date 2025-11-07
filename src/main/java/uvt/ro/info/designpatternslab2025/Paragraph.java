package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Paragraph extends BookElement implements Cloneable {

    private String text;
    @ManyToOne
    @JoinColumn(name = "align_strategy_id")
    private AlignDirection alignStrategy = null;
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Long id;

    public AlignDirection getAlignStrategy() {
        return alignStrategy;
    }

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        if (alignStrategy == null) {
            System.out.println(text);
        } else {
            alignStrategy.render(this);
        }
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignDirection strategy) {
        this.alignStrategy = strategy;
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
    public Paragraph clone() {
        return new Paragraph(this.text); // shallow clone
    }

}

