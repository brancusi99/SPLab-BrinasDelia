package uvt.ro.info.designpatternslab2025;

public class AlignLeft extends AlignDirection {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("<< " + paragraph.getText());
    }
}

