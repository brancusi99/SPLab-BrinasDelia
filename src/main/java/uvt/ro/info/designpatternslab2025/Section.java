package uvt.ro.info.designpatternslab2025;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element, Cloneable {

    private String title;
    private List<Element> elements = new ArrayList<>();

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
    public void add(Element element) {
        elements.add(element.clone());  // ✅ clone when added
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
            copy.add(e.clone());        // ✅ deep clone children
        }
        return copy;
    }
}

