public class Memory {
    private String name;

    public Memory(String name) {
        this.name = name;
    }

    public void allocate(int size) {
        System.out.println("Allocating " + size + " bytes of memory: " + name);
    }
}