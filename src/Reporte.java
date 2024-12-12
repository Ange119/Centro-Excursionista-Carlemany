import java.util.List;
import java.util.Map;

public class Reporte {
    private List<Expedicionario> participante;
    private Map<Expedicionario, Rol> rolParticipantes;
    private boolean cimaAlcanza;

    public Reporte(List<Expedicionario> participante, Map<Expedicionario, Rol> rolParticipantes) {
        this.participante = participante;
        this.rolParticipantes = rolParticipantes;
        this.cimaAlcanza = false;
    }

    public void generarReporte() {
        System.out.println("Generando reporte detallado de la expedición");
    }
}
