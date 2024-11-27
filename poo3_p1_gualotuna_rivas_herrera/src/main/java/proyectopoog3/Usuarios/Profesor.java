package proyectopoog3.Usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import proyectopoog3.App;
import proyectopoog3.ManejoArchivos;
import proyectopoog3.Enums.EstadoEspacio;
import proyectopoog3.Enums.EstadoReserva;
import proyectopoog3.Enums.RolesPermitidos;
import proyectopoog3.EspacioYReserva.Espacio;
import proyectopoog3.EspacioYReserva.Reserva;

import java.util.Properties;


public class Profesor extends Usuario {
    private String facultad;
    private ArrayList<String> materias;

    // Constructor Profesor

    public Profesor(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña,
            String correo, String facultad, ArrayList<String> materias) {
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.facultad = facultad;
        this.materias = materias;
    }

    // Setters

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

    // Getters

    public String getFacultad() {
        return facultad;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    // Metodos

    @Override
    public void gestionarReserva(ArrayList<Espacio> espacios) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Espacios disponibles para profesores: ");
        for (Espacio espacio : espacios) {
            if (espacio.getRolesPermitidos().equals(RolesPermitidos.PROFESOR) || espacio.getRolesPermitidos().equals(RolesPermitidos.AMBOS)) {

                if (espacio.getEstado().equals(EstadoEspacio.DISPONIBLE)) {
                    System.out.println("Espacios disponibles: ");
                    System.out.println(espacio);

                }
            }

        }
        System.out.println("Ingrese el codigo del espacio que desea reservar: ");
        String codSelection = sc.nextLine();
        String motivo;
        System.out.println("Para cual de sus materias es esta reserva: ");
        int contador = 1;
        for(String materia: materias){
            System.out.println(contador+". "+materia);
            contador+=1;
        }
        System.out.print("Escriba el numero de su eleccion: ");
        int eleccion = sc.nextInt();
        sc.nextLine();
        motivo = materias.get(eleccion-1);
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
                Reserva reserva = new Reserva(Reserva.generarCodeReserva(), super.codeUser, super.cedula, fdate, Espacio.generarCodigoEspacio(), espacio.getTipo(), EstadoReserva.APROBADO, motivo, this.getCorreo());
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
                    System.out.println("Fue APROBADA CON EXITO.");
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

    public void enviarMail(String receptor, Reserva reserva) {
        Session ses =  super.iniciarSesion();
                try{
            Message mes = new MimeMessage(ses);
            mes.setFrom(new InternetAddress(this.correo, "Prof. " + nombre));
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
            mes.setSubject("Reserva realizada");
            mes.setText("Se le notifica que el profesor " + nombre +  "\n" + //
                                apellido +  "ha realizado una reserva con codigo\n" + //
                                reserva.getCodReserva() +" para la fecha" + reserva.getFecha() + " en el auditorio\n" + //
                                reserva.getEspacio() + " para la materia\n" + //
                                "Fundamentos de Programación.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Profesor{" +
               "codeUser='" + codeUser + '\'' +
               ", cedula='" + cedula + '\'' +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", usuario='" + usuario + '\'' +
               ", contraseña='" + contraseña + '\'' +
               ", correo='" + correo + '\'' +
               ", facultad='" + facultad + '\'' +
               ", materias='" + materias + '\'' +
               '}';
    }

}
