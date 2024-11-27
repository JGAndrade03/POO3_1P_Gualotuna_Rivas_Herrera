package proyectopoog3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

public class Reserva {
    public static int reservasCreadas = 0;
    private int codReserva;
    private String codUsuario;
    private String cedulaUsuario;
    private LocalDate fecha;
    private int codEspacio;
    private TipoEspacio espacio;
    private EstadoReserva estadoR;
    private String motivo;
    public static ArrayList<Reserva> reservas = new ArrayList<>();

    // Constructor Reserva

    public Reserva(int codReserva, String codUsuario, String cedulaUsuario, LocalDate fecha, int codEspacio, TipoEspacio espacio, EstadoReserva estadoR,
            String motivo) {
        this.codReserva = codReserva;
        this.codUsuario = codUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.fecha = fecha;
        this.codEspacio = codEspacio;
        this.espacio = espacio;
        this.estadoR = estadoR;
        this.motivo = motivo;
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
        sc.close();
        
        return null;
                    
    }

    public static int generarCodeReserva() {

        Random random = new Random();
        int numAle = 1000 + random.nextInt(9000);

        return numAle;

    }

    public String toString() {
        return "Reserva{" +
               "codReserva=" + codReserva +
               ", codUsuario='" + codUsuario + '\'' +
               ", cedulaUsuario='" + cedulaUsuario + '\'' +
               ", fecha=" + fecha +
               ", codEspacio=" + codEspacio +
               ", espacio=" + espacio +
               ", estadoR=" + estadoR +
               ", motivo='" + motivo + '\'' +
               '}';
    }

}
