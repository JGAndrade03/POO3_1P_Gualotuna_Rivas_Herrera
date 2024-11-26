package proyectopoog3;

import java.util.ArrayList;

public class Reserva {
    public static int reservasCreadas = 0;
    private String codReserva;
    private String usuario;
    private TipoEspacio espacio;
    private EstadoReserva estadoR;
    private String motivo;

    //Constructor Reserva

    public Reserva(String codReserva, String usuario, TipoEspacio espacio, EstadoReserva estadoR, String motivo){
        this.codReserva=codReserva;
        this.usuario=usuario;
        this.espacio=espacio;
        this.estadoR=estadoR;
        this.motivo=motivo;
    }

    //Setters Reserva 

    public void setCodReserva(String codReserva){
        this.codReserva=codReserva;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
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

    public String getUsuario(){
        return usuario;
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

   public static void verificarUsuario(ArrayList<Usuario> usuarios){

   }

   public void generarCodeReserva(){

   }
    
}
