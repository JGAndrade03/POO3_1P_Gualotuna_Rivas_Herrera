package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
    private String cargo;

// Constructor Admin

    public Administrador(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String cargo){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
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
    public void gestionarReserva(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas){
        Scanner sc = new Scanner(System.in);

        System.out.println("====================== Gestión de Reservas ========================");
        if(reservas.isEmpty()){
            System.out.println("No hay reservas pendientes por revisar.");

        }else{
            for(Reserva reserva : reservas){
                if(reserva.getEstadoR().equals(EstadoReserva.PENDIENTE)){
                    System.out.println("La reserva: "+reserva+" se encuentra en estado pendiente");

                    System.out.println("¿Desea aprobar (A) o rechazar (R) la reserva? \n (A/R)");
                    String seleccion = sc.nextLine().toUpperCase();

                    if(seleccion.equals("A")){
                        reserva.setEstadoR(EstadoReserva.APROBADO);
                        System.out.println("Reserva Aprobada");

                    }else if(seleccion.equals("R")){
                        System.out.println("Ingrese motivo del rechazo: ");
                        String motivoR = sc.nextLine();

                        reserva.setEstadoR(EstadoReserva.RECHAZADO);
                        reserva.setMotivo(motivoR);

                        System.out.println("Su reserva ha sido rechazada por el siguiente motivo: "+motivoR);
                    }

                }
            }

        }

    }






}
