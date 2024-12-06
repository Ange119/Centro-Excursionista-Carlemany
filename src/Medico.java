public class Medico extends Expedicionario {
    private String especialidad;

    public Medico(String id ,String nombre , String especialidad ) {
        super(id,nombre , Rol.MEDICO);
        this.especialidad = especialidad;

    }

    public void atender(){
        System.out.println("El Medico esta atendiendo  ... ");
    }

    public String getEspecialidad() {
        return especialidad;
    }

}
