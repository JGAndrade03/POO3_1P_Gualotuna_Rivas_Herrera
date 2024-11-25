package proyectopoog3;

public class Espacio {
    private String codEspacio;
    private TipoEspacio tipo;
    private String nombre;
    private int capacidad;
    private EstadoEspacio estado;
    private String rolesPermitidos;

    public Espacio(String codEspacio, TipoEspacio tipo, String nombre, int capacidad, EstadoEspacio estado, String rolesPertidos){
        this.codEspacio=codEspacio;
        this.tipo=tipo;
        this.nombre=nombre;
        this.capacidad=capacidad;
        this.estado=estado;
        this.rolesPermitidos=rolesPertidos;
    }

    //setters
    public void setcodEspacio(String codEspacio){
        this.codEspacio=codEspacio;
    }
    public void settipo(TipoEspacio tipo){
        this.tipo=tipo;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setcapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public void setestado(EstadoEspacio estado){
        this.estado=estado;
    }
    public void setrolesPermitidos(String rolesPermitidos){
        this.rolesPermitidos=rolesPermitidos;
    }

    //getters

    public String getcodEspacio(){
        return codEspacio;
    }
    public TipoEspacio gettipo(){
        return tipo;
    }
    public String getnombre(){
        return nombre;
    }
    public int getcapacidad(){
        return capacidad;
    }
    public EstadoEspacio getestado(){
        return estado;
    }
    public String getRolesPermitidos(){
        return rolesPermitidos;
    }

    public void generarCodigoEspacio(){
        
    }
}
