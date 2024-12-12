
public class Alpinista extends Expedicionario {
    private boolean cimaAlcanzada;

    public Alpinista(String id, String nombre) {
        super(id, nombre, Rol.ALPINISTA);
        this.cimaAlcanzada = false;
    }

    public void registrarCima() {
        this.cimaAlcanzada = true;
    }

    public boolean isCimaAlcanzada() {
        return cimaAlcanzada;
    }
}