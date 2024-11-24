package proyectopoog3;

public class Estudiante extends Usuario {
    protected String matricula;
    protected String carrera;

    public  Estudiante(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String matricula, String carrera){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.matricula = matricula;
        this.carrera = carrera;
    }

    //Setters

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public void setCarrera(String carrera){
        this.carrera=carrera;
    }

    // Getters

    public String getMatricula(){
        return matricula;
    }

    public String getCarrera(){
        return carrera;
    }

    // Metodos  

    @Override
    public void reservar() {
        super.reservar();
    }

    @Override
    public void consultarReserva() {
        super.consultarReserva();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
            "codeUser='" + codeUser + '\'' +
            ", cedula='" + cedula + '\'' +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", usuario='" + usuario + '\'' +
            ", contraseña='" + contraseña + '\'' +
            ", correo='" + correo + '\'' +
            ", matricula='" + matricula + '\'' +
            ", carrera='" + carrera + '\'' +
            '}';
}
}
