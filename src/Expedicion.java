import java.util.Date;
import java.util.List;

public class Expedicion {
    private String id;
    private Date fecha;
    private Montana montana;
    private List<Expedicionario> expedicionarios;

    public Expedicion(String id, Date fecha, Montana montana, List<Expedicionario> expedicionarios) {
        this.id = id;
        this.fecha = fecha;
        this.montana = montana;
        this.expedicionarios = expedicionarios;
    }

    public void registrarParticipante(Expedicionario expedicionario) {
        expedicionarios.add(expedicionario);
    }

    public void marcarCimaAlcanzada() {
        System.out.println("La cima ha sido alcanzada.");
    }

    public List<Expedicionario> getExpedicionarios() {
        return expedicionarios;
    }

    public Montana getMontana() {
        return montana;
    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }
}