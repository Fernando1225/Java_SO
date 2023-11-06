import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String groupAddress = "230.0.0.0";
            int port = 4321;
            int bufferSize = 1024;

            MulticastCoordinator coordinator = new MulticastCoordinator(groupAddress, port, bufferSize);
            MulticastSender sender = new MulticastSender(groupAddress, port);
            MulticastReceiver receiver = new MulticastReceiver(groupAddress, port, bufferSize);

            // Test sending and receiving messages
            coordinator.sendMessage("Hello, multicast group!");
            System.out.println("Received message: " + coordinator.receiveMessage());

            // Close the coordinator, sender, and receiver
            coordinator.close();
            sender.close();
            receiver.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}