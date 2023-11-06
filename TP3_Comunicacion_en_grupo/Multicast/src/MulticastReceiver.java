import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    private InetAddress group;
    private int port;
    private MulticastSocket socket;
    private byte[] buffer;

    public MulticastReceiver(String groupAddress, int port, int bufferSize) throws IOException {
        this.group = InetAddress.getByName(groupAddress);
        this.port = port;
        this.socket = new MulticastSocket(port);
        this.socket.joinGroup(group);
        this.buffer = new byte[bufferSize];
    }

    public String receiveMessage() throws IOException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void close() throws IOException {
        socket.leaveGroup(group);
        socket.close();
    }
}