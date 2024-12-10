import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear listas
        List<Expedicionario> expedicionarios = new ArrayList<>();
        List<Montana> montanas = new ArrayList<>();
        List<Expedicion> expediciones = new ArrayList<>();

        boolean salir = false;

        while (!salir) {
            // Menú
            System.out.println("\nGestión de Expediciones - Menú");
            System.out.println("1. Registrar Montaña");
            System.out.println("2. Registrar Expedicionario");
            System.out.println("3. Crear Expedición");
            System.out.println("4. Ejecutar Acciones de los Expedicionarios");
            System.out.println("5. Generar Reporte de Expedición");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    // Registrar Montaña
                    System.out.println("Ingrese el nombre de la montaña:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la altura de la montaña (en metros):");
                    double altura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la dificultad de la montaña:");
                    String dificultad = scanner.nextLine();
                    montanas.add(new Montana(nombre, altura, dificultad));
                    System.out.println("Montaña registrada exitosamente.");
                    break;

                case 2:
                    // Registrar Expedicionario
                    System.out.println("Ingrese el nombre del expedicionario:");
                    String nombreExpedicionario = scanner.nextLine();
                    System.out.println("Seleccione el rol del expedicionario (1: Alpinista, 2: Médico):");
                    int rol = scanner.nextInt();
                    scanner.nextLine();
                    if (rol == 1) {
                        expedicionarios.add(new Alpinista("A" + (expedicionarios.size() + 1), nombreExpedicionario));
                        System.out.println("Alpinista registrado exitosamente.");
                    } else if (rol == 2) {
                        System.out.println("Ingrese la especialidad del médico:");
                        String especialidad = scanner.nextLine();
                        expedicionarios.add(new Medico("M" + (expedicionarios.size() + 1), nombreExpedicionario, especialidad));
                        System.out.println("Médico registrado exitosamente.");
                    } else {
                        System.out.println("Rol no válido.");
                    }
                    break;

                case 3:
                    // Crear Expedición
                    if (montanas.isEmpty()) {
                        System.out.println("No hay montañas registradas.");
                        break;
                    }
                    System.out.println("Seleccione una montaña para la expedición:");
                    for (int i = 0; i < montanas.size(); i++) {
                        System.out.println((i + 1) + ". " + montanas.get(i).getNombre());
                    }
                    int seleccionMontana = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Montana montanaSeleccionada = montanas.get(seleccionMontana);
                    Expedicion nuevaExpedicion = new Expedicion(
                            "E" + (expediciones.size() + 1),
                            new Date(),
                            montanaSeleccionada,
                            new ArrayList<>(),
                            new ArrayList<>()
                    );
                    expediciones.add(nuevaExpedicion);
                    System.out.println("Expedición creada exitosamente.");
                    break;

                case 4:
                    // Ejecutar acciones de expedicionarios (Polimorfismo)
                    for (Expedicionario expedicionario : expedicionarios) {
                        expedicionario.realizarAccion();
                    }
                    break;

                case 5:
                    // Generar Reporte
                    if (expediciones.isEmpty()) {
                        System.out.println("No hay expediciones creadas.");
                        break;
                    }
                    System.out.println("Seleccione una expedición para generar reporte:");
                    for (int i = 0; i < expediciones.size(); i++) {
                        System.out.println((i + 1) + ". Expedición ID: " + expediciones.get(i).getID());
                    }
                    int seleccionReporte = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Expedicion reporteExpedicion = expediciones.get(seleccionReporte);
                    reporteExpedicion.generarReporte();
                    break;

                case 6:
                    // Salir
                    salir = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
