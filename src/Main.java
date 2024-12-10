import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear lista de expedicionarios y montañas
        List<Alpinista> alpinistas = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<Montana> montanas = new ArrayList<>();
        List<Expedicion> expediciones = new ArrayList<>();

        System.out.println("Gestión de Expediciones - Sistema Interactivo");
        
        // Ingresar montañas
        System.out.println("Ingrese el número de montañas que desea registrar:");
        int numMontanas = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        for (int i = 0; i < numMontanas; i++) {
            System.out.println("Ingrese el nombre de la montaña:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la altura de la montaña (en metros):");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            System.out.println("Ingrese la dificultad de la montaña:");
            String dificultad = scanner.nextLine();
            montanas.add(new Montana(nombre, altura, dificultad));
        }

        // Ingresar expedicionarios
        System.out.println("Ingrese el número de expedicionarios que desea registrar:");
        int numExpedicionarios = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        for (int i = 0; i < numExpedicionarios; i++) {
            System.out.println("Ingrese el nombre del expedicionario:");
            String nombre = scanner.nextLine();
            System.out.println("Seleccione el rol del expedicionario (1: Alpinista, 2: Médico):");
            int rol = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            if (rol == 1) {
                alpinistas.add(new Alpinista("A" + (alpinistas.size() + 1), nombre));
            } else if (rol == 2) {
                System.out.println("Ingrese la especialidad del médico:");
                String especialidad = scanner.nextLine();
                medicos.add(new Medico("M" + (medicos.size() + 1), nombre, especialidad));
            } else {
                System.out.println("Rol no válido, intente nuevamente.");
                i--;
            }
        }

        // Crear expedición
        System.out.println("Creando expedición...");
        System.out.println("Seleccione una montaña para la expedición:");
        for (int i = 0; i < montanas.size(); i++) {
            System.out.println((i + 1) + ". " + montanas.get(i).getNombre());
        }
        int seleccionMontana = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea

        Montana montanaSeleccionada = montanas.get(seleccionMontana);

        Expedicion nuevaExpedicion = new Expedicion(
                "E" + (expediciones.size() + 1),
                new Date(),
                montanaSeleccionada,
                alpinistas,
                medicos
        );
        expediciones.add(nuevaExpedicion);

        // Registrar si alpinistas alcanzaron la cima
        System.out.println("Registro de cimas alcanzadas:");
        for (Alpinista alpinista : alpinistas) {
            System.out.println("¿El alpinista " + alpinista.getNombre() + " alcanzó la cima? (1: Sí, 2: No)");
            int respuesta = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            alpinista.registrarCima(respuesta == 1);
        }

        // Generar reporte
        System.out.println("Generando reporte de la expedición:");
        for (Alpinista alpinista : nuevaExpedicion.getAlpinistas()) {
            System.out.println("Alpinista: " + alpinista.getNombre() + ", Cima alcanzada: " + alpinista.isCimaAlcanzada());
        }
        for (Medico medico : nuevaExpedicion.getMedicos()) {
            System.out.println("Médico: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad());
        }
        System.out.println("Montaña de la expedición: " + nuevaExpedicion.getMontana().getNombre());

        scanner.close();
    }
}
