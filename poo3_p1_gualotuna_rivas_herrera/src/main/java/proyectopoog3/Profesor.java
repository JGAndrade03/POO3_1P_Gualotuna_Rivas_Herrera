package proyectopoog3;

public class Profesor extends Usuario{
    protected String facultad;
    protected String materias;

//Setters

    public void setFacultad(String facultad){
        this.facultad=facultad;
    }

    public void setMaterias(String materias){
        this.materias=materias;
    }

// Getters

    public String getFacultad(){
        return facultad;
    }

    public String getMaterias(){
        return materias;
    }


//Metodos

    public void reserva(String usuario, String cedula){

    }

    //public String consultarReserva(String usuario, String correo, String cedula){}
        

    

}
