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
                    if (expedicionarios.isEmpty()) {
                        System.out.println("No hay expedicionarios registrados.");
                        break;
                    }
                
                    // Verificar si hay al menos un médico registrado
                    boolean hayMedico = expedicionarios.stream().anyMatch(exp -> exp instanceof Medico);
                    if (!hayMedico) {
                        System.out.println("Error: No hay médicos registrados en el sistema. No se puede crear una expedición.");
                        break;
                    }
                
                    // Seleccionar Montaña
                    System.out.println("Seleccione una montaña para la expedición:");
                    for (int i = 0; i < montanas.size(); i++) {
                        System.out.println((i + 1) + ". " + montanas.get(i).getNombre());
                    }
                    int seleccionMontana = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Montana montanaSeleccionada = montanas.get(seleccionMontana);
                
                    // Seleccionar Participantes
                    List<Alpinista> alpinistas = new ArrayList<>();
                    List<Medico> medicos = new ArrayList<>();
                    boolean participantesValidos = false;
                
                    while (!participantesValidos) {
                        alpinistas.clear();
                        medicos.clear();
                        System.out.println("Seleccione los participantes de la expedición:");
                        for (int i = 0; i < expedicionarios.size(); i++) {
                            Expedicionario exp = expedicionarios.get(i);
                            System.out.println((i + 1) + ". " + exp.getNombre() + " (" + exp.obtenerRol() + ")");
                        }
                        System.out.println("Ingrese los números de los participantes separados por comas:");
                        String[] indices = scanner.nextLine().split(",");
                        for (String indice : indices) {
                            int pos = Integer.parseInt(indice.trim()) - 1;
                            Expedicionario seleccionado = expedicionarios.get(pos);
                            if (seleccionado instanceof Alpinista) {
                                alpinistas.add((Alpinista) seleccionado);
                            } else if (seleccionado instanceof Medico) {
                                medicos.add((Medico) seleccionado);
                            }
                        }
                
                        // Validar que haya al menos un médico
                        if (medicos.isEmpty()) {
                            System.out.println("Error: La expedición debe incluir al menos un médico. Seleccione nuevamente.");
                        } else {
                            participantesValidos = true;
                        }
                    }
                
                    // Registrar si alpinistas alcanzaron la cima
                    System.out.println("Registro de cimas alcanzadas:");
                    for (Alpinista alpinista : alpinistas) {
                        System.out.println("¿El alpinista " + alpinista.getNombre() + " alcanzó la cima? (1: Sí, 2: No)");
                        int respuesta = scanner.nextInt();
                        scanner.nextLine(); 
                        alpinista.registrarCima(respuesta == 1);
                    }
                
                    // Crear Expedición
                    Expedicion nuevaExpedicion = new Expedicion(
                            "E" + (expediciones.size() + 1),
                            new Date(),
                            montanaSeleccionada,
                            alpinistas,
                            medicos
                    );
                    expediciones.add(nuevaExpedicion);
                    System.out.println("Expedición creada exitosamente con participantes asignados.");
                    break;

                case 4:
                    // Ejecutar acciones de expedicionarios (Polimorfismo)
                    if (expedicionarios.isEmpty()) {
                        System.out.println("No hay expedicionarios registrados.");
                    } else {
                        for (Expedicionario expedicionario : expedicionarios) {
                            expedicionario.realizarAccion();
                        }
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
