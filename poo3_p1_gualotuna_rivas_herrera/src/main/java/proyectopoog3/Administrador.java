package proyectopoog3;

public class Administrador extends Usuario {
    protected String cargo;

    public Administrador(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String cargo){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.cargo=cargo;
    }

    //Setters

    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    // Getters

    public String getCargo(){
        return cargo;
    }

    //Metodos
    
    public void gestionarReserva(String codReserva){

    }

    @Override
    public String toString() {
        return "Administrador{" +
               "codeUser='" + codeUser + '\'' +
               ", cedula='" + cedula + '\'' +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", usuario='" + usuario + '\'' +
               ", contraseña='" + contraseña + '\'' +
               ", correo='" + correo + '\'' +
               ", cargo='" + cargo + '\'' +
               '}';
    }
}