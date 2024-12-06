public class Alpinista extends Expedicionario {
    private boolean cimaAlcanzada;

    public Alpinista(String ID , String nombre) {
        super(ID , nombre , Rol.ALPINISTA);
        this.cimaAlcanzada = false;
    }

    public boolean registrarCima( boolean cimaAlcanzada){
        this.cimaAlcanzada = cimaAlcanzada;
        return cimaAlcanzada;
    }

    public boolean isCimaAlcanzada(){
        return cimaAlcanzada;
    }




}
