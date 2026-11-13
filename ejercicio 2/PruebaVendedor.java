
import javax.swing.JOptionPane;

public class PruebaVendedor {
    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog(
                "Ingrese el nombre del vendedor:"
            );

            if (nombre == null) return;

            String apellidos = JOptionPane.showInputDialog(
                "Ingrese los apellidos del vendedor:"
            );

            if (apellidos == null) return;

            String datoEdad = JOptionPane.showInputDialog(
                "Ingrese la edad del vendedor:"
            );

            if (datoEdad == null) return;

            int edad = Integer.parseInt(datoEdad);

            Vendedor vendedor = new Vendedor(nombre, apellidos);
            vendedor.verificarEdad(edad);

            JOptionPane.showMessageDialog(
                null,
                vendedor.imprimir(),
                "Datos del vendedor",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "Debe ingresar una edad válida.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error de edad",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}