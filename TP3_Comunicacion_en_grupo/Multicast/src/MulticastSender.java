import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    private InetAddress group;
    private int port;
    private DatagramSocket socket;

    public MulticastSender(String groupAddress, int port) throws IOException {
        this.group = InetAddress.getByName(groupAddress);
        this.port = port;
        this.socket = new DatagramSocket();
    }

    public void sendMessage(String message) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
        socket.send(packet);
    }

    public void close() {
        socket.close();
    }
}