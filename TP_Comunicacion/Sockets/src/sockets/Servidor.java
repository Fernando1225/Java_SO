package sockets;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // Crear un socket de datagramas
        DatagramSocket socket = new DatagramSocket(5001);

        // Bucle infinito para escuchar conexiones entrantes
        while (true) {
            // Crear un paquete de datagrama para recibir datos
            DatagramPacket paquete = new DatagramPacket(new byte[1024], 1024);

            // Recibir datos del cliente
            socket.receive(paquete);

            // Obtener la dirección IP y el puerto del cliente
            InetAddress direccionIP = paquete.getAddress();
            int puerto = paquete.getPort();

            // Decodificar el mensaje recibido
            String mensaje = new String(paquete.getData(), 0, paquete.getLength());

            // Imprimir el mensaje recibido
            System.out.println("Mensaje recibido del cliente: " + mensaje);

            // Crear un paquete de datagrama para enviar una respuesta
            DatagramPacket paqueteRespuesta = new DatagramPacket(
                    "Hola, cliente!".getBytes(), "Hola, cliente!".length(),
                    direccionIP, puerto
            );

            // Enviar una respuesta al cliente
            socket.send(paqueteRespuesta);
        }
    }
}
