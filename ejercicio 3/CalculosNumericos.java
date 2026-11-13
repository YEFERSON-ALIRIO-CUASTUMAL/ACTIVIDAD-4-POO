import javax.swing.JOptionPane;

public class CalculosNumericos {

    public static double calcularLogaritmoNeperiano(double valor) {
        if (valor <= 0) {
            throw new ArithmeticException(
                "El valor debe ser positivo para calcular el logaritmo."
            );
        }
        return Math.log(valor);
    }

    public static double calcularRaizCuadrada(double valor) {
        if (valor <= 0) {
            throw new ArithmeticException(
                "El valor debe ser positivo para calcular la raíz cuadrada."
            );
        }
        return Math.sqrt(valor);
    }

    public static void main(String[] args) {
        try {
            String dato = JOptionPane.showInputDialog(
                null,
                "Ingrese un número:",
                "Cálculos numéricos",
                JOptionPane.QUESTION_MESSAGE
            );

            if (dato == null) {
                return;
            }

            double valor = Double.parseDouble(dato);

            double logaritmo = calcularLogaritmoNeperiano(valor);
            double raiz = calcularRaizCuadrada(valor);

            JOptionPane.showMessageDialog(
                null,
                "Número ingresado: " + valor
                + "\nLogaritmo neperiano: " + logaritmo
                + "\nRaíz cuadrada: " + raiz,
                "Resultados",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "Debe ingresar un número válido.",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error aritmético",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
