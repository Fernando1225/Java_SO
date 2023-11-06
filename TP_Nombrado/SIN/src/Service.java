public class Service {
    private String name;

    public Service(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Running service: " + name);
    }
}