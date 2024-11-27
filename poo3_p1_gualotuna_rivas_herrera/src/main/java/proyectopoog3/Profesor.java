package proyectopoog3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Usuario {
    private String facultad;
    private String materias;

    // Constructor Profesor

    public Profesor(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña,
            String correo, String facultad, String materias) {
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.facultad = facultad;
        this.materias = materias;
    }

    // Setters

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    // Getters

    public String getFacultad() {
        return facultad;
    }

    public String getMaterias() {
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
        System.out.println("Ingrese el motivo de su reserva: ");
        String motivo = sc.nextLine();
        System.out.println("Escriba la fecha de su reserva con el formato AAAA-MM-DD: ");
        String fecha = sc.nextLine();

        LocalDate fdate = LocalDate.parse(fecha);

        for( Espacio espacio : espacios){
            if (codSelection.equals(espacio.getcodEspacio())) {
                Reserva reserva = new Reserva(Reserva.generarCodeReserva(), super.codeUser, super.cedula, fdate, Espacio.generarCodigoEspacio(), espacio.getTipo(), EstadoReserva.APROBADO, motivo);
                Reserva.reservasCreadas++;

                String codR = String.valueOf(reserva.getCodReserva());
                String tipoE = reserva.getEspacio().toString();
                String estadoR = reserva.getEstadoR().toString();

                String linea = "\n"+codR+" | "+super.codeUser+" | "+fdate+" | "+tipoE+" | "+estadoR+" | "+motivo;
                                                                                                     
                Reserva.reservas.add(reserva);
                ManejoArchivos.EscribirArchivo("reservas.txt", linea);
            }

        }
        App.mostrarMenu(this, espacios);
        sc.close();

    }

    @Override
    public void consultarReserva() {

    }

    public void enviarMail(String correo) {

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
