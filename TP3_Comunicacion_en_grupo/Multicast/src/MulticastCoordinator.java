import java.io.IOException;

public class MulticastCoordinator {
    private MulticastSender sender;
    private MulticastReceiver receiver;

    public MulticastCoordinator(String groupAddress, int port, int bufferSize) throws IOException {
        this.sender = new MulticastSender(groupAddress, port);
        this.receiver = new MulticastReceiver(groupAddress, port, bufferSize);
    }

    public void sendMessage(String message) throws IOException {
        sender.sendMessage(message);
    }

    public String receiveMessage() throws IOException {
        return receiver.receiveMessage();
    }

    public void close() throws IOException {
        sender.close();
        receiver.close();
    }
}