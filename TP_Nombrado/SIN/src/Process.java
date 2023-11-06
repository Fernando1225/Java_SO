public class Process {
    private String name;

    public Process(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("Starting process: " + name);
    }
}