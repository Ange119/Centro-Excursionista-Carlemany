    public abstract class Expedicionario {

        private String ID;
        private String nombre;
        private Rol rol ;

        public Expedicionario(String ID, String nombre, Rol rol) {
            this.ID = ID;
            this.nombre = nombre;
            this.rol = rol;
        }

        public Rol obtenerRol() {
            return rol;
        }
        public String getID() {
            return ID;
        }
        public String getNombre() {
            return nombre;
        }

        public abstract void realizarAccion();

}
