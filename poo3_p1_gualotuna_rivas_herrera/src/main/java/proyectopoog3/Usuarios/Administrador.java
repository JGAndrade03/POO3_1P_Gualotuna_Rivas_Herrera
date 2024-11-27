package proyectopoog3.Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import proyectopoog3.App;
import proyectopoog3.ManejoArchivos;
import proyectopoog3.Enums.EstadoReserva;
import proyectopoog3.EspacioYReserva.Espacio;
import proyectopoog3.EspacioYReserva.Reserva;

import java.util.Properties;


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
        for(Reserva res: App.reservas){
            if(res.getEstadoR().equals(EstadoReserva.PENDIENTE)){
                System.out.println(res);
                
            }
        }
        System.out.println("Ingrese el codigo de la reserva que desea gestionar: ");
        String codSelection = sc.nextLine();
        
        for(Reserva res: App.reservas){
            String codR = String.valueOf(res.getCodReserva());
            if(codR.equals(codSelection)){
                System.out.println("¿Desea aprobar (A) o rechazar (R) la reserva? \n (A/R):");
                String seleccion = sc.nextLine().toUpperCase();
                if (seleccion.equals("A")) {
                    res.setEstadoR(EstadoReserva.APROBADO);
                    System.out.println("Reserva Aprobada");
                    enviarMail(res.getcorreoUsuario(), res);

                    ArrayList<String> a6 = ManejoArchivos.leeFichero("reservas.txt");
                    for(String linea: a6){
                        String[] a_reserva = linea.strip().split("\\|");
                        ArrayList<String> l_reserva = new ArrayList<>();
                        for(String elemento : a_reserva){
                            l_reserva.add(elemento.strip());
                        }
                        if(l_reserva.get(0).equals(res.getCodReserva())){
                            String newEstado = l_reserva.get(6);
                            linea = res.getCodReserva()+" | "+res.getCodUsuario()+" | "+res.getCedulaUsuario()+" | "+res.getFecha()+" | "+res.getCodEspacio()+" | "+res.getEspacio()+" | "+res.getEstadoR()+" | "+res.getMotivo();
                        }
                    }

                } else if (seleccion.equals("R")) {
                    System.out.println("Ingrese motivo del rechazo: ");
                    String motivoR = sc.nextLine();
                    res.setEstadoR(EstadoReserva.RECHAZADO);
                    res.setMotivo("Reserva Rechazada");
                    enviarMail(res.getcorreoUsuario(), res);
                    ArrayList<String> a6 = ManejoArchivos.leeFichero("reservas.txt");
                    for(String linea: a6){
                        String[] a_reserva = linea.strip().split("\\|");
                        ArrayList<String> l_reserva = new ArrayList<>();
                        for(String elemento : a_reserva){
                            l_reserva.add(elemento.strip());
                        }
                        if(l_reserva.get(0).equals(res.getCodReserva())){
                            String newEstado = l_reserva.get(6);
                            linea = res.getCodReserva()+" | "+res.getCodUsuario()+" | "+res.getCedulaUsuario()+" | "+res.getFecha()+" | "+res.getCodEspacio()+" | "+res.getEspacio()+" | "+res.getEstadoR()+" | "+res.getMotivo();
                        }
                    }
                }
            }

            
    
            }
            App.mostrarMenu(this, espacios);
        }


    @Override
    public void consultarReserva(ArrayList<Reserva> reservas){
        
        System.out.println("Número de reservas creadas: "+Reserva.reservasCreadas);
        for (Reserva reserva : App.reservas){
            System.out.println(reserva);
        }
        App.mostrarMenu(this, App.espacios);
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
