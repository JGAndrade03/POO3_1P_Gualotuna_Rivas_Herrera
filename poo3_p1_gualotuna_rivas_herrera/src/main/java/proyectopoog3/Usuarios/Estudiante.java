package proyectopoog3.Usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

//librerias para correos
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import proyectopoog3.App;
import proyectopoog3.ManejoArchivos;
import proyectopoog3.Enums.EstadoEspacio;
import proyectopoog3.Enums.EstadoReserva;
import proyectopoog3.Enums.RolesPermitidos;
import proyectopoog3.EspacioYReserva.Espacio;
import proyectopoog3.EspacioYReserva.Reserva;

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
    public void gestionarReserva(ArrayList<Espacio> espacios) {

        Scanner sc = new Scanner(System.in); 

        System.out.println("Espacios disponibles para estudiantes: ");
        for (Espacio espacio : espacios) {
            if (espacio.getRolesPermitidos().equals(RolesPermitidos.ESTUDIANTE) || espacio.getRolesPermitidos().equals(RolesPermitidos.AMBOS)) {

                if (espacio.getEstado().equals(EstadoEspacio.DISPONIBLE)) {
                    System.out.println("Espacios disponibles: ");
                    System.out.println(espacio);

                }
            }

        }
        System.out.println("Ingrese el codigo del espacio que desea reservar: ");
        String codSelection = sc.nextLine();
        System.out.println("Ingrese el motivo de su reserva: ");
        String motivo = sc.nextLine();

        LocalDate fdate = null;
        boolean fechaValida = false;
        while (!fechaValida) {
        System.out.println("Escriba la fecha de su reserva con el formato AAAA-MM-DD: ");
        String fecha = sc.nextLine();
        try {
            fdate = LocalDate.parse(fecha);  // Intenta convertir la fecha a LocalDate
            fechaValida = true;  // La fecha es válida, salimos del ciclo
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Por favor, ingrese una fecha en el formato AAAA-MM-DD.");
        }
        }

        for( Espacio espacio : espacios){
            if (codSelection.equals(espacio.getcodEspacio())) {
                Reserva reserva = new Reserva(Reserva.generarCodeReserva(), super.codeUser, super.cedula, fdate, Espacio.generarCodigoEspacio(), espacio.getTipo(), EstadoReserva.PENDIENTE, motivo, this.getCorreo());
                Reserva.reservasCreadas++;

                String codR = String.valueOf(reserva.getCodReserva());
                String codE = String.valueOf(reserva.getCodEspacio());
                String tipoE = reserva.getEspacio().toString();
                String estadoR = reserva.getEstadoR().toString();

                String linea = "\n"+codR+" | "+super.codeUser+" | "+super.cedula+" | "+fdate+" | "+codE+" | "+tipoE+" | "+estadoR+" | "+motivo;
                
                System.out.println("Desea realizar la reserva (Si/No): ");
                String election = sc.nextLine();
                if(election.toUpperCase().equals("SI")){
                    Reserva.reservas.add(reserva);
                    ManejoArchivos.EscribirArchivo("reservas.txt", linea);
                    System.out.println("Su "+reserva);
                    System.out.println("Se encuentra pendiente.");
                    this.enviarMail("cgomez@universidad.edu", reserva);
                    Reserva.reservasCreadas++;
                    App.mostrarMenu(this, espacios);
                }else{
                    App.mostrarMenu(this, espacios);
                }

                
            }else{
                System.out.println("Seleccione un codigo valido");
                App.mostrarMenu(this, espacios);
            }

        }
        sc.close();

    }

    @Override
    public void consultarReserva(ArrayList<Reserva> reservas) {
        Scanner sc = new Scanner(System.in);
        LocalDate fdate = null;
        boolean fechaValida = false;

        while (!fechaValida) {
        System.out.println("Escriba la fecha de su reserva con el formato AAAA-MM-DD: ");
        String fecha = sc.nextLine();

        try {
            fdate = LocalDate.parse(fecha); 
            fechaValida = true; 
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Por favor, ingrese una fecha en el formato AAAA-MM-DD.");
        }
        }

    
        for (Reserva res : reservas) {
            String fdateReserva = res.getFecha().toString(); 
            if ( this.getCodeUser().equals(res.getCodUsuario())) {
            System.out.println(res);
        }
        }
        App.mostrarMenu(this, App.espacios);
    }


    public void enviarMail(String receptor, Reserva reserva){
       Session ses =  super.iniciarSesion();
                try{
            Message mes = new MimeMessage(ses);
            mes.setFrom(new InternetAddress(this.correo, "Estuiante" + nombre));
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
            mes.setSubject("Reserva Realizada");
            mes.setText("El estudiante" +nombre+ " y"+ apellido+" ha\n" + //
                                "realizado una reserva con código"+ reserva.getCodReserva()+"para\n" + //
                                "la fecha "+reserva.getFecha()+" en la cancha "+reserva.getEspacio()+ ".\n" + //
                                "Ingrese al sistema para aprobar o rechazar la\n" + //
                                "reserva.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    

}
