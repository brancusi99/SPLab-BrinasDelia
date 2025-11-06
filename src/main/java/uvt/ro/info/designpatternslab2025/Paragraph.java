package uvt.ro.info.designpatternslab2025;

public class Paragraph implements Element, Cloneable {

    private String text;
    private AlignStrategy alignStrategy = null;

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

    public void setAlignStrategy(AlignStrategy strategy) {
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

