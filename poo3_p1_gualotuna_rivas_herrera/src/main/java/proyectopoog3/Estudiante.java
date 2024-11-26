package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante extends Usuario {
    private String matricula;
    private String carrera;

    //Constructor Estudiante

    public Estudiante(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String matricula, String carrera){
        super(codeUser,cedula,nombre,apellido,usuario,contraseña,correo);
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
    public void gestionarReserva(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas){
        System.out.println("Espacios disponibles para estudiantes: "); //AJUSTAR METODO RESERVA PARA ESTUDIANTE
        for(Espacio espacio : espacios){
            if(espacio.getRolesPermitidos().equals(RolesPermitidos.ESTUDIANTE) || espacio.getRolesPermitidos().equals(RolesPermitidos.AMBOS)){
            
                if(espacio.getEstado().equals(EstadoEspacio.DISPONIBLE)){
                    System.out.println("El espacio: "+espacio+" con codigo: "+espacio.getcodEspacio()+ "esta disponible");
                }
            }

        }

    }

    @Override
    public void consultarReserva() {
    
    }

    

}
