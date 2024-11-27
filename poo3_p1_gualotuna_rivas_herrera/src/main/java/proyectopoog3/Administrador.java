package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

    //@Override
    // public void consultarReserva(){
    //     System.out.println("Los administradores no consultan reserva");
    // }

    @Override
    public void gestionarReserva(ArrayList<Espacio> espacios) {
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
                        enviarMail(continuar, reserva); //la reseerva deberia incluir el mail de quien la realixa para saber a donde enviar el correo de resultado

                    }else if(seleccion.equals("R")){
                        System.out.println("Ingrese motivo del rechazo: ");
                        String motivoR = sc.nextLine();
        
                        reserva.setEstadoR(EstadoReserva.RECHAZADO);
                        reserva.setMotivo(motivoR);
                        eniarMail(continuar, reserva); //la reseerva deberia incluir el mail de quien la realixa para saber a donde enviar el correo de resultado
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
        // if(Reserva.reservasCreadas == 0){
        //     System.out.println("No hay reservas por consultar");
        // }
        // Usuario user = Reserva.verificarUsuario(usuarios);
        // System.out.println("Número de reservas creadas: "+Reserva.reservasCreadas);
        // for(Reserva reserva : Reserva.reservas){
        //     if(reserva instanceof(Estudiante))

        // }



    }
    //@Override
    public void enviarMail(String receptor, Reserva res) {
               Session ses =  super.iniciarSesion();
                try{
            Message mes = new MimeMessage(ses);
            mes.setFrom(new InternetAddress(this.correo, "Admin. " + nombre));
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));//error, la reserva deheria incluir el correo de quien la realiza
            if (res.getEstadoR() == EstadoReserva.APROBADO){
                mes.setSubject("Reserva Aprobada");
                mes.setText("Se ha aprobado su reserva con código" + res.getCodReserva() + " \n. Atentamente, Departamento Administrativo");
            }else if (res.getEstadoR() == EstadoReserva.RECHAZADO){
                mes.setSubject("Reserva Rechazada");
                mes.setText("Se ha rechazado su reserva con código" + res.getCodReserva() +"por el motivo" + res.getMotivo() + " \n. Atentamente, Departamento Administrativo");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
 
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
