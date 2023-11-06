public class Main {
    public static void main(String[] args) {
        IntegralNamingSystem sin = new IntegralNamingSystemImpl();

        // Bind resources
        sin.bind("file1", new File("file1.txt"));
        sin.bind("process1", new Process("process1"));
        sin.bind("service1", new Service("service1"));
        sin.bind("memory1", new Memory("memory1"));

        // Lookup resources
        File file1 = (File) sin.lookup("file1");
        Process process1 = (Process) sin.lookup("process1");
        Service service1 = (Service) sin.lookup("service1");
        Memory memory1 = (Memory) sin.lookup("memory1");

        // Use the resources
        file1.open();
        process1.start();
        service1.run();
        memory1.allocate(1024);

        // Unbind a resource
        sin.unbind("file1");
    }
}