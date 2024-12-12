public class Montana {
    private String nombre;
    private double altura;
    private String dificultad;

    public Montana(String nombre, double altura, String dificultad) {
        this.nombre = nombre;
        this.altura = altura;
        this.dificultad = dificultad;
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

    public void actualizarCatalogo() {
        System.out.println("Actualizando catálogo de montañas...");
    }
}