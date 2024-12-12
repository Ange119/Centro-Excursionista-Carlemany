public class Alpinista extends Expedicionario {
    private boolean cimaAlcanzada;

    public Alpinista(String ID, String nombre) {
        super(ID, nombre, Rol.ALPINISTA);
        this.cimaAlcanzada = false;
    }

    public boolean registrarCima(boolean cimaAlcanzada) {
        this.cimaAlcanzada = cimaAlcanzada;
        return cimaAlcanzada;
    }

    public boolean isCimaAlcanzada() {
        return cimaAlcanzada;
    }

    @Override
    public void realizarAccion() {
        if (cimaAlcanzada) {
            System.out.println("El Alpinista " + getNombre() + " ya ha alcanzado la cima.");
        } else {
            System.out.println("El Alpinista " + getNombre() + " está escalando...");
        }
    }
}
