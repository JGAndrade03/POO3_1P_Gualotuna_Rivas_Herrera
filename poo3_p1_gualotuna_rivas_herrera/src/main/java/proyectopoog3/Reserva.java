package proyectopoog3;

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

    
}
