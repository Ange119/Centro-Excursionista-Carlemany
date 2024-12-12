public abstract class Expedicionario {
    private String id;
    private String nombre;
    private Rol rol;

    public Expedicionario(String id, String nombre, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
}