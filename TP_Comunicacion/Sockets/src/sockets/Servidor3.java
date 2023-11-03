package sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor3 {

    public static void main(String[] args) throws IOException {
        // Crear un socket de datagramas para escuchar peticiones
        DatagramSocket socket = new DatagramSocket(5006);

        // Bucle infinito para escuchar peticiones entrantes
        while (true) {
            // Crear un paquete de datagrama para recibir datos
            DatagramPacket paquete = new DatagramPacket(new byte[1024], 1024);

            // Recibir datos del cliente
            socket.receive(paquete);

            // Obtener la dirección IP y el puerto del cliente
            InetAddress direccionIP = paquete.getAddress();
            int puerto = paquete.getPort();

            // Decodificar la petición recibida
            String peticion = new String(paquete.getData(), 0, paquete.getLength());

            // Crear un paquete de datagrama para enviar una respuesta
            byte[] bytesRespuesta = ("Respuesta: " + peticion.toUpperCase()).getBytes();
            DatagramPacket paqueteRespuesta = new DatagramPacket(
                    bytesRespuesta, bytesRespuesta.length,
                    direccionIP, puerto
            );

            // Enviar una respuesta al cliente
            socket.send(paqueteRespuesta);

            // Crear un paquete de datagrama para enviar un acuse de recibo
            byte[] bytesAcuse = "Recibido".getBytes();
            DatagramPacket paqueteAcuse = new DatagramPacket(
                    bytesAcuse, bytesAcuse.length,
                    direccionIP, puerto
            );

            // Enviar un acuse de recibo al cliente
            socket.send(paqueteAcuse);
        }
    }
}
