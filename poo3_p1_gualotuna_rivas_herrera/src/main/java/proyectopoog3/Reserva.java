package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    public static int reservasCreadas = 0;
    private String codReserva;
    private Usuario usuario;
    private Espacio espacio;
    private EstadoEspacio estadoE;
    private EstadoReserva estadoR;
    private String motivo;

    //Constructor Reserva

    public Reserva(String codReserva, Usuario usuario, Espacio espacio, EstadoEspacio estadoE, EstadoReserva estadoR, String motivo){
        this.codReserva=codReserva;
        this.usuario=usuario;
        this.espacio=espacio;
        this.estadoE=estadoE;
        this.estadoR=estadoR;
        this.motivo=motivo;
    }

    //Setters Reserva 

    public void setCodReserva(String codReserva){
        this.codReserva=codReserva;
    }

    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }

    public void setEspacio(Espacio espacio){
        this.espacio=espacio;
    }

    public void setEstadoE(EstadoEspacio estadoE){
        this.estadoE=estadoE;
    }

    public void setEstadoR(EstadoReserva estadoR){
        this.estadoR=estadoR;
    }

    public void setMotivo(String motivo){
        this.motivo=motivo;
    }

    //Getters Reserva

    public String getCodReserva(){
        return codReserva;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public Espacio getEspacio(){
        return espacio;
    }

    public EstadoEspacio getEstadoE(){
        return estadoE;
    }

    public EstadoReserva getEstadoR(){
        return estadoR;
    }

    public String getMotivo(){
        return motivo;
    }

    public static Usuario verificarUsuario(ArrayList<Usuario> usuarios){
        System.out.println("Bienvenido - Realiza tu reserva.");
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
                return null;
    }
}
