import java.net.*;
import java.io.*;

/**
 * server
 */
public class serverCC {
    private ServerSocket servidor;
    private Socket conexion;
    private BufferedInputStream buffEntrada;
    private BufferedOutputStream buffSalida;
    private DataInputStream datosEntrada;
    private byte[] tDatosRecibidos;
    private int tamanio;
    private String dirArchivo;

    public static void main(String[] args) {
        serverCC app = new serverCC();
        app.init();
        
    }

    public void init() {

        try {
            servidor = new ServerSocket(5000);

            while (true) {
                System.out.println("Esperando conexion...");
                conexion = servidor.accept();
                System.out.println("Conexion establecida.");

                tDatosRecibidos = new byte[1024];
                buffEntrada = new BufferedInputStream(conexion.getInputStream());
                datosEntrada = new DataInputStream(conexion.getInputStream());

                dirArchivo = datosEntrada.readUTF();

                dirArchivo = dirArchivo.substring(dirArchivo.indexOf('\\') + 1, dirArchivo.length());

                buffSalida = new BufferedOutputStream(new FileOutputStream(dirArchivo));
                System.out.println("Archivo recibido y descargado con exito: " + dirArchivo);

                tamanio = buffEntrada.read(tDatosRecibidos);
                while (tamanio != -1) {
                    buffSalida.write(tDatosRecibidos, 0, tamanio);

                }

                buffSalida.close();
                datosEntrada.close();

            }

        } catch (Exception e) {
            System.err.print(e);
        }
        
    }

}
