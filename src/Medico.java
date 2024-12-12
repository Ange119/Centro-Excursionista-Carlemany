public class Medico extends Expedicionario {
    private String especialidad;

    public Medico(String id, String nombre, String especialidad) {
        super(id, nombre, Rol.MEDICO);
        this.especialidad = especialidad;
    }

    public void atender() {
        System.out.println("El Médico " + getNombre() + " está atendiendo...");
    }

    @Override
    public void realizarAccion() {
        atender();
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
