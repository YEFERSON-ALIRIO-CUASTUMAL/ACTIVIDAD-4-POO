
import java.io.*;
import javax.swing.JOptionPane;

public class LeerArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "prueba.txt";
        StringBuilder contenido = new StringBuilder();

        try {
            FileInputStream archivo = new FileInputStream(nombreArchivo);
            InputStreamReader conversor = new InputStreamReader(archivo);
            BufferedReader filtro = new BufferedReader(conversor);

            String linea = filtro.readLine();

            while (linea != null) {
                contenido.append(linea).append("\n");
                linea = filtro.readLine();
            }

            filtro.close();

            JOptionPane.showMessageDialog(
                null,
                contenido.length() == 0
                    ? "El archivo está vacío."
                    : contenido.toString(),
                "Contenido del archivo",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "No se pudo leer el archivo.",
                "Error de lectura",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
