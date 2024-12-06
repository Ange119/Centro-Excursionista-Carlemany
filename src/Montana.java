public class Montana {
    private String nombre ;
    private double altura;
    private String dificultad;

    //Constructor
    public Montana(String nombre , double  altura, String dificultad) {
        this.nombre = nombre; // aqui llamo a la variable nombre y que se aguarde en nombre del constructor
        this.altura = altura;
        this.dificultad = dificultad;
    }

    public void actualizarCatalogo(){
        System.out.println("Actualizando catalogo de montañas ...");

    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public String getDificultad() {
        return dificultad;
    }




}
