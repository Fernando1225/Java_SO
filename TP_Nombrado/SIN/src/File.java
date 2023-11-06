public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Opening file: " + name);
    }
}
