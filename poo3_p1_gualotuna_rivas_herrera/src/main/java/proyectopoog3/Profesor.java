package proyectopoog3;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Usuario{
    private String facultad;
    private String materias;

//Constructor Profesor

    public Profesor(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String facultad, String materias){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.facultad=facultad;
        this.materias=materias;
    }

//Setters

    public void setFacultad(String facultad){
        this.facultad=facultad;
    }

    public void setMaterias(String materias){
        this.materias=materias;
    }

// Getters

    public String getFacultad(){
        return facultad;
    }

    public String getMaterias(){
        return materias;
    }


//Metodos

    @Override
    public void reservar(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas){

        System.out.println("Espacios disponibles para profesores: ");
        for(Espacio espacio : espacios){
            if(espacio.getRolesPermitidos().equals(RolesPermitidos.PROFESOR) || espacio.getRolesPermitidos().equals(RolesPermitidos.AMBOS)){
            
                if(espacio.getEstado().equals(EstadoEspacio.DISPONIBLE)){
                    System.out.println("El espacio: "+espacio+" esta disponible");
                }
            }

        }

       


    }

    @Override
    public void gestionarReserva(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas){
        System.out.println("Los profesores no pueden gestionar reservas");
    }

    @Override
    public void consultarReserva() {
        
    }


    public void enviarMail(String correo){
        

    }

   
        

    

}
