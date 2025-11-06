package uvt.ro.info.designpatternslab2025;

public interface Element extends Cloneable {
    void print();
    void add(Element element);
    void remove(Element element);
    Element get(int index);
    Element clone();
}

