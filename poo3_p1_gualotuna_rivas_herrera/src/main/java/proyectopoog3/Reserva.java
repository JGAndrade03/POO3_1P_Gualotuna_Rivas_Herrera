package proyectopoog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    public static int reservasCreadas = 0;
    private String codReserva;
    private String codUsuario;
    private String cedulaUsuario;
    private String fecha;
    private String codEspacio;
    private TipoEspacio espacio;
    private EstadoReserva estadoR;
    private String motivo;

    //Constructor Reserva

    public Reserva(String codReserva, String codUsuario, TipoEspacio espacio, EstadoReserva estadoR, String motivo){
        this.codReserva=codReserva;
        this.codUsuario=codUsuario;
        this.espacio=espacio;
        this.estadoR=estadoR;
        this.motivo=motivo;
    }

    //Setters Reserva 

    public void setCodReserva(String codReserva){
        this.codReserva=codReserva;
    }

    public void setUsuario(String codUsuario){
        this.codUsuario=codUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario){
        this.cedulaUsuario=cedulaUsuario;
    }

    public void setFecha(String fecha){
        this.fecha=fecha;
    }

    public void setCodEspacio(String codEspacio){
        this.codEspacio=codEspacio;
    }

    public void setEspacio(TipoEspacio espacio){
        this.espacio=espacio;
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

    public String getCodUsuario(){
        return codUsuario;
    }

    public String getCedulaUsuario(){
        return cedulaUsuario;
    }

    public String getFecha(){
        return fecha;
    }

    public String getCodEspacio(){
        return codEspacio;
    }

    public TipoEspacio getEspacio(){
        return espacio;
    }

    public EstadoReserva getEstadoR(){
        return estadoR;
    }

    public String getMotivo(){
        return motivo;
    }


    //METODOS RESERVA

   public static Usuario verificarUsuario(String usuario, String contrasena, ArrayList<Usuario> usuarios){

        for(Usuario user : usuarios){
            if(user.getUsuario().equalsIgnoreCase(usuario) && user.validarCredencial(usuario, contrasena)){
                return user;
            }
        }
        return null;
           

        

    }
    



   public void generarCodeReserva(){

   }
    
}
