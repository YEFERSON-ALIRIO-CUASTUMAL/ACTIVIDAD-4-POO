
import javax.swing.JOptionPane;

public class EquipoMaratonProgramacion {
    private String nombreEquipo;
    private String universidad;
    private String lenguajeProgramacion;
    private Programador[] programadores;
    private int cantidad;

    public EquipoMaratonProgramacion(String nombreEquipo,
            String universidad, String lenguajeProgramacion,
            int tamanoEquipo) {

        if (tamanoEquipo < 2 || tamanoEquipo > 3) {
            throw new IllegalArgumentException(
                "El equipo debe tener entre 2 y 3 programadores."
            );
        }

        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.programadores = new Programador[tamanoEquipo];
        this.cantidad = 0;
    }

    public boolean equipoCompleto() {
        return cantidad == programadores.length;
    }

    public void agregarProgramador(Programador programador) {
        if (equipoCompleto()) {
            throw new IllegalArgumentException(
                "El equipo ya está completo."
            );
        }

        programadores[cantidad] = programador;
        cantidad++;
    }

    public static void validarCampo(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El campo " + campo + " no puede estar vacío."
            );
        }

        if (texto.length() >= 20) {
            throw new IllegalArgumentException(
                "El campo " + campo + " debe tener menos de 20 caracteres."
            );
        }

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                throw new IllegalArgumentException(
                    "El campo " + campo + " no puede tener dígitos."
                );
            }
        }
    }

    public String imprimir() {
        String resultado = "Equipo: " + nombreEquipo
            + "\nUniversidad: " + universidad
            + "\nLenguaje: " + lenguajeProgramacion
            + "\nIntegrantes: " + cantidad + "\n";

        for (int i = 0; i < cantidad; i++) {
            resultado += "\n" + (i + 1) + ". "
                + programadores[i].imprimir();
        }

        return resultado;
    }

    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog(
                "Nombre del equipo:");
            if (nombre == null) return;
            if (nombre.trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "El nombre del equipo es obligatorio.");
            }

            String universidad = JOptionPane.showInputDialog(
                "Universidad:");
            if (universidad == null) return;
            if (universidad.trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "La universidad es obligatoria.");
            }

            String lenguaje = JOptionPane.showInputDialog(
                "Lenguaje de programación:");
            if (lenguaje == null) return;
            if (lenguaje.trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "El lenguaje es obligatorio.");
            }

            String datoTamano = JOptionPane.showInputDialog(
                "Cantidad de integrantes (2 o 3):");
            if (datoTamano == null) return;

            int tamano = Integer.parseInt(datoTamano);

            EquipoMaratonProgramacion equipo =
                new EquipoMaratonProgramacion(
                    nombre, universidad, lenguaje, tamano);

            for (int i = 0; i < tamano; i++) {
                String nombreProgramador =
                    JOptionPane.showInputDialog(
                        "Nombre del integrante " + (i + 1) + ":");
                if (nombreProgramador == null) return;

                validarCampo(nombreProgramador, "nombre");

                String apellidos =
                    JOptionPane.showInputDialog(
                        "Apellidos del integrante " + (i + 1) + ":");
                if (apellidos == null) return;

                validarCampo(apellidos, "apellidos");

                equipo.agregarProgramador(
                    new Programador(nombreProgramador, apellidos));
            }

            JOptionPane.showMessageDialog(
                null,
                equipo.imprimir(),
                "Equipo registrado",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "La cantidad de integrantes debe ser un número.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error de validación",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
