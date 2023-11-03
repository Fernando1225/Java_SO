package sockets;

import java.io.IOException;

public class Ejemplo {

    public static void main(String[] args) throws IOException {
        // Crear un cliente
        ComunicacionTCP cliente = new ComunicacionTCPImpl("localhost", 5004);

        // Enviar un mensaje al servidor
        cliente.enviarMensaje("Hola, servidor!");

        // Recibir una respuesta del servidor
        String respuesta = cliente.recibirMensaje();

        // Cerrar la conexión con el servidor
        cliente.cerrarConexion();

        // Imprimir la respuesta recibida
        System.out.println("Respuesta recibida: " + respuesta);
    }
}
