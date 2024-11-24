package proyectopoog3;

public class Profesor extends Usuario{
    protected String facultad;
    protected String materias;

//Constructor Profesor

    public Profesor(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, String facultad, String materias){
        super(codeUser, cedula, nombre, apellido, usuario, contraseña, correo);
        this.facultad=facultad;
        this.materias=materias;
    }

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

    @Override
    public void gestionarReserva(){
        System.out.println("Reserva realizada por profesor: "+super.nombre+" "+super.apellido+" con usuario: "+super.usuario);

    }

    @Override
    public void consultarReserva() {
        
    }


    public void enviarMail(String correo){
        

    }

   
        

    

}
