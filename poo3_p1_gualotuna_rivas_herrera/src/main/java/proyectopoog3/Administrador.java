package proyectopoog3;

public class Administrador extends Usuario {
    private String cargo;

// Constructor Admin

    public Administrador(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, char rol, String cargo){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.cargo=cargo;
    }

    //Setters Admin

    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    //Getter Admin

    public String getCargo(){
        return cargo;
    }

    // Metodos admin

    @Override
    public void consultarReserva(){
        System.out.println("Los administradores no consultan reserva");
    }

    @Override
    public void gestionarReserva(){
        System.out.println("Reserva gestionada");
    }






}
