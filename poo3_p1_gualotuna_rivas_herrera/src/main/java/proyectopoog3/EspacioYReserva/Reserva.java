package proyectopoog3.EspacioYReserva;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import proyectopoog3.App;
import proyectopoog3.Enums.EstadoReserva;
import proyectopoog3.Enums.TipoEspacio;
import proyectopoog3.Usuarios.Usuario;

import java.time.LocalDate;

public class Reserva {
    public static int reservasCreadas = 15;
    private int codReserva;
    private String codUsuario;
    private String cedulaUsuario;
    private LocalDate fecha;
    private int codEspacio;
    private TipoEspacio espacio;
    private EstadoReserva estadoR;
    private String motivo;
    private String correoUsuario;
    public static ArrayList<Reserva> reservas = new ArrayList<>();

    // Constructor Reserva

    public Reserva(int codReserva, String codUsuario, String cedulaUsuario, LocalDate fecha, int codEspacio, TipoEspacio espacio, EstadoReserva estadoR,
            String motivo, String correoUsuario) {
        this.codReserva = codReserva;
        this.codUsuario = codUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.fecha = fecha;
        this.codEspacio = codEspacio;
        this.espacio = espacio;
        this.estadoR = estadoR;
        this.motivo = motivo;
        this.correoUsuario = correoUsuario;
    }

    // Setters Reserva

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public void setUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCodEspacio(int codEspacio) {
        this.codEspacio = codEspacio;
    }

    public void setEspacio(TipoEspacio espacio) {
        this.espacio = espacio;
    }

    public void setEstadoR(EstadoReserva estadoR) {
        this.estadoR = estadoR;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Getters Reserva

    public int getCodReserva() {
        return codReserva;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCodEspacio() {
        return codEspacio;
    }

    public TipoEspacio getEspacio() {
        return espacio;
    }

    public EstadoReserva getEstadoR() {
        return estadoR;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getcorreoUsuario(){
        return correoUsuario;
    }

    // METODOS RESERVA

    public static Usuario verificarUsuario(ArrayList<Usuario> usuarios){
        System.out.println("------------------------------------------------------------");
        System.out.println("Bienvenido - Ingrese al sistema.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();
        for(Usuario user: usuarios){
            if(user.getUsuario().equals(usuario)&&user.getContraseña().equals(contraseña)){
                
                return user;
            }
        }

        System.out.println("Usuario no encontrado");
        App.mostrarMenu(verificarUsuario(App.usuarios), App.espacios);
        sc.close();
        
        return null;      
    }

    public static int generarCodeReserva() {

        Random random = new Random();
        int numAle = 1000 + random.nextInt(9000);

        return numAle;

    }

    public String toString() {
        return "Reserva {" +
               "codigo: " + codReserva +
               " | codigo del usuario: " + codUsuario +
               " | cedula: " + cedulaUsuario +
               " | fecha: " + fecha +
               " | codigo del espacio: " + codEspacio +
               " | espacio: " + espacio +
               " | estado de la Reserva: " + estadoR +
               " | motivo: " + motivo + 
               '}';
    }

}