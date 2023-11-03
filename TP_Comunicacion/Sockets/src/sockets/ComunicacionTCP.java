package sockets;

import java.io.IOException;

public interface ComunicacionTCP {

    /**
     * Envia un mensaje al servidor.
     *
     * @param mensaje El mensaje a enviar.
     * @throws IOException Si se produce un error de red.
     */
    void enviarMensaje(String mensaje) throws IOException;

    /**
     * Recibe un mensaje del servidor.
     *
     * @return El mensaje recibido.
     * @throws IOException Si se produce un error de red.
     */
    String recibirMensaje() throws IOException;

    /**
     * Cierra la conexión con el servidor.
     *
     * @throws IOException Si se produce un error de red.
     */
    void cerrarConexion() throws IOException;
}

