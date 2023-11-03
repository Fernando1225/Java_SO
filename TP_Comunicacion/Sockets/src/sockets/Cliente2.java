package sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente2 {

    public static void main(String[] args) throws IOException {
        // Configurar la dirección IP y el puerto del servidor
        InetAddress direccionIP = InetAddress.getByName("localhost");
        int puerto = 5006;

        // Crear un socket de datagramas para enviar peticiones
        DatagramSocket socket = new DatagramSocket();

        // Enviar una petición al servidor
        String peticion = "Hola, servidor!";
        DatagramPacket paquete = new DatagramPacket(peticion.getBytes(), peticion.length(), direccionIP, puerto);
        socket.send(paquete);

        // Recibir una respuesta del servidor
        byte[] buffer = new byte[1024];
        DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);
        socket.receive(paqueteRespuesta);

        // Decodificar la respuesta recibida
        String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());

        // Imprimir la respuesta recibida
        System.out.println("Respuesta recibida del servidor: " + respuesta);
    }
}
