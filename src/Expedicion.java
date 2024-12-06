import java.util.Date;
import java.util.List;

public class Expedicion {
    private String ID;
    private Date Fecha;
    private Montana montana ;
    private List<Alpinista> alpinistas;
    private List<Medico> medicos;
    private boolean cimaAlcanzada;

    public Expedicion(String ID, Date fecha , Montana montana , List<Alpinista> alpinistas , List<Medico> medicos ) {
        this.ID = ID;
        this.Fecha = fecha;
        this.montana = montana;
        this.alpinistas = alpinistas;
        this.medicos = medicos;
        this.cimaAlcanzada = false;
    }

    public void registrarParticipacion(Expedicionario expedicionario) {
        if(expedicionario instanceof Alpinista) {
            alpinistas.add((Alpinista)expedicionario);
        }else if (expedicionario instanceof Medico) {
            medicos.add((Medico)expedicionario);
        }
    }

    public void generarReporte(){
        System.out.println("Generando  reporte ... ");
    }

    public boolean isCimaAlcanzada() {
        return cimaAlcanzada;
    }
}
