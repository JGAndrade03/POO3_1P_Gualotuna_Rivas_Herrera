package proyectopoog3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
                    System.out.println(
                            "El " + espacio.getTipo() + ": " + espacio.getnombre() + " con codigo: " + espacio.getcodEspacio() + " esta disponible");

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
        System.out.println("Escriba la fecha de su reserva con el formato AAAA-MM-DD: ");
        String fecha = sc.nextLine();

        LocalDate fdate = LocalDate.parse(fecha);

        for( Espacio espacio : espacios){
            if (codSelection.equals(espacio.getcodEspacio())) {
                Reserva reserva = new Reserva(Reserva.generarCodeReserva(), super.codeUser, super.cedula, fdate, Espacio.generarCodigoEspacio(), espacio.getTipo(), EstadoReserva.APROBADO, motivo);
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
                    System.out.println("Su reserva fue realizada con exito.");
                    enviarMail("cgomez@universidad.edu", reserva);//se quemo el coreo de uno de los administradores. como se escoge el administrador a quien enviar?
                    App.mostrarMenu(this, espacios);
                }else{
                    App.mostrarMenu(this, espacios);
                }
            }

        }
        sc.close();

    }

    @Override
    public void consultarReserva() {

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
