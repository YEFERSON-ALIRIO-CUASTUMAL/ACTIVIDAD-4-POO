
import javax.swing.JOptionPane;

public class PruebaExcepciones {

    public static void main(String[] args) {

        String resultado = "";

        // Primer bloque try
        try {
            resultado += "Ingresando al primer try\n";

            int divisor = 0;
            double cociente = 10000 / divisor;

            resultado += "Después de la división\n";

        } catch (ArithmeticException e) {
            resultado += "División por cero\n";

        } finally {
            resultado += "Ingresando al primer finally\n";
        }

        // Segundo bloque try
        try {
            resultado += "\nIngresando al segundo try\n";

            Object objeto = null;
            objeto.toString();

            resultado += "Imprimiendo objeto\n";

        } catch (ArithmeticException e) {
            resultado += "División por cero\n";

        } catch (Exception e) {
            resultado += "Ocurrió una excepción\n";

        } finally {
            resultado += "Ingresando al segundo finally\n";
        }

        // Mostrar los resultados en una ventana
        JOptionPane.showMessageDialog(
            null,
            resultado,
            "Prueba de excepciones",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
