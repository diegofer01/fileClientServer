import java.net.*;
import java.io.*;

public class clientCC {
    private BufferedInputStream buffEntrada;
    private BufferedOutputStream buffSalida;
    private byte[] byteArray;
    // Fichero a transferir
    private final String dirArchivo = "E:/UNICAUCA/2022 - 1/Enfasis III/vid.mp4";

    public static void main(String[] args) {
        clientCC c1 = new clientCC();
        c1.enviarArchivo();
    }

    public void enviarArchivo() {

        try {

            final File archivo = new File(dirArchivo);
            Socket client = new Socket("localhost", 5000);
            buffEntrada = new BufferedInputStream(new FileInputStream(archivo));
            buffSalida = new BufferedOutputStream(client.getOutputStream());
            // Enviamos el nombre del fichero
            DataOutputStream datosSalida = new DataOutputStream(client.getOutputStream());
            datosSalida.writeUTF(archivo.getName());
            // Enviamos el fichero
            byteArray = new byte[8192];
            // while ((in = bis.read(byteArray)) != -1) {
            // bos.write(byteArray, 0, in);
            // }

            buffSalida.write(byteArray, 0, 2000000);
            // bos.write(byteArray, 0, bis.read(byteArray));
            buffEntrada.close();
            buffSalida.close();
            client.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        
    }

    
}
