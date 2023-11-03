package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ComunicacionTCPImpl implements ComunicacionTCP {

    private Socket socket;

    /**
     * Crea una nueva instancia de `ComunicacionTCPImpl`.
     *
     * @param direccionIP La dirección IP del servidor.
     * @param puerto El puerto del servidor.
     * @throws IOException Si se produce un error de red.
     */
    public ComunicacionTCPImpl(String direccionIP, int puerto) throws IOException {
        this.socket = new Socket(direccionIP, puerto);
    }

    @Override
    public void enviarMensaje(String mensaje) throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(mensaje);
        out.flush();
    }

    @Override
    public String recibirMensaje() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        return in.readUTF();
    }

    @Override
    public void cerrarConexion() throws IOException {
        socket.close();
    }
}
