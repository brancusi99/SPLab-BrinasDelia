package uvt.ro.info.designpatternslab2025;

public interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    Element get(int index);
}
