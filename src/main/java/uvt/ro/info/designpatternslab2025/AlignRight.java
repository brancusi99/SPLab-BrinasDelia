package uvt.ro.info.designpatternslab2025;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println(paragraph.getText() + " >>");
    }
}

