package uvt.ro.info.designpatternslab2025;

public class Author {
    private String name;
    private String surname;

    public Author(String name) {
        this.name = name;
        //this.surname = surname;
    }

    public void print() {
        System.out.println("Author: " + name + " " + surname);
    }
}

