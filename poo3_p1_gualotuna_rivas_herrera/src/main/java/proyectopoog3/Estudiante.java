package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante extends Usuario {
    private String matricula;
    private String carrera;

    //Constructor Estudiante

    public Estudiante(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, char rol, String matricula, String carrera){
        super(codeUser,cedula,nombre,apellido,usuario,contraseña,correo,rol);
        this.matricula=matricula;
        this.carrera=carrera;
    }

    //Setters Estudiante

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public void setCarrera(String carrera){
        this.carrera=carrera;
    }

    //Getters Estudiante

    public String getMatricula(){
        return matricula;
    }

    public String getCarrera(){
        return carrera;
    }


    //Metodos Estudiante

    @Override
    public void gestionarReserva(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Espacio disponible para estudiantes: ");

        System.out.println("Reserva realizada por el estudiante: "+super.nombre+" "+super.apellido+" con usuario: "+super.usuario);
        
    }

    @Override
    public void consultarReserva() {
    
    }

}
