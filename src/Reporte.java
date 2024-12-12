import java.util.List;
import java.util.Map;

public class Reporte {
    private List<Expedicionario> participantes;
    private Map<String, Rol> rolesParticipantes;
    private boolean cimaAlcanzada;

    public Reporte(List<Expedicionario> participantes, Map<String, Rol> rolesParticipantes, boolean cimaAlcanzada) {
        this.participantes = participantes;
        this.rolesParticipantes = rolesParticipantes;
        this.cimaAlcanzada = cimaAlcanzada;
    }

    public void generarReporte() {
        System.out.println("Generando reporte de la expedición:");
        System.out.println("Cima alcanzada: " + (cimaAlcanzada ? "Sí" : "No"));
        System.out.println("Participantes:");
        for (Expedicionario e : participantes) {
            System.out.println("- " + e.getNombre() + " (" + e.getRol() + ")");
        }
    }
}