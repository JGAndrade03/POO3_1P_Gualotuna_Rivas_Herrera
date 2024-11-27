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
    public void gestionarReserva(ArrayList<Espacio> espacios){
        Scanner sc = new Scanner(System.in);
        String continuar;

        do{
            System.out.println("====================== Gestión de Reservas ========================");
            if(Reserva.reservas.isEmpty()){
                System.out.println("No hay reservas pendientes por revisar.");
    
            }else{
                for(Reserva reserva : Reserva.reservas){
                    if(reserva.getEstadoR().equals(EstadoReserva.PENDIENTE)){
                        System.out.println("La reserva: "+reserva.getCodReserva()+" se encuentra en estado pendiente");
    
                    }
    
                }
    
                for(Reserva reserva : Reserva.reservas){
    
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
            System.out.println("Desea continuar con la revisión? (Si/No)");
            continuar = sc.nextLine().toUpperCase();
        

            
        }while(continuar.equals("SI"));

        System.out.println("Gestion de reservas finalizada");
    
        sc.close();

    }


    @Override
    public void consultarReserva(){
        if(Reserva.reservasCreadas == 0){
            System.out.println("No hay reservas por consultar");
        }
        Usuario user = Reserva.verificarUsuario(usuario);
        System.out.println("Número de reservas creadas: "+Reserva.reservasCreadas);
        for(Reserva reserva : Reserva.reservas){
            if(reserva instanceof(Estudiante))

        }



    }

    public void enviarMail(String correo) {

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
