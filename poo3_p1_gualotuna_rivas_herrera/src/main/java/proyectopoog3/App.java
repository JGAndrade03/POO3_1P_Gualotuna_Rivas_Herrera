package proyectopoog3;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Listas de objetos
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Espacio> espacios = new ArrayList<>();
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    
        public static void mostrarMenu(Usuario user, ArrayList<Espacio> espacios){
            Scanner sc = new Scanner(System.in);
            System.out.println("------------------------------------------------------------");
            if(user instanceof Estudiante){
                Estudiante est = (Estudiante) user;
                System.out.println("Bienvenido estudiante: "+est.getNombre()+" "+est.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva\n\t3. Salir");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();

                if(eleccion == 1){
                    est.gestionarReserva(espacios);
                }else if(eleccion == 2){
                    est.consultarReserva();
                }else if(eleccion == 3){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                }
            }else if(user instanceof Profesor){
                Profesor prof = (Profesor) user;
                System.out.println("Bienvenido profesor/a: "+prof.getNombre()+" "+prof.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva\n\t3. Salir");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();
                if(eleccion == 1){
                    prof.gestionarReserva(espacios);
                }else if(eleccion == 2){
                    prof.consultarReserva();
                }else if(eleccion == 3){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                }
            }else if(user instanceof Administrador){
                Administrador admin = (Administrador) user;
                System.out.println("Bienvenido administrador/a: "+admin.getNombre()+" "+admin.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva\n\t3. Salir");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();
                if(eleccion == 1){
                    admin.gestionarReserva(espacios);
                }else if(eleccion == 2){
                    admin.consultarReserva();
                }else if(eleccion == 3){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                }

            }sc.close();
        } 
    
        public static void main(String[] args) {
            
    
            // Archivos
            ArrayList<String> a1 = ManejoArchivos.leeFichero("usuarios.txt");
            ArrayList<String> a2 = ManejoArchivos.leeFichero("estudiantes.txt");
            ArrayList<String> a3 = ManejoArchivos.leeFichero("profesores.txt");
            ArrayList<String> a4 = ManejoArchivos.leeFichero("administradores.txt");
            ArrayList<String> a5 = ManejoArchivos.leeFichero("espacios.txt");
            ArrayList<String> a6 = ManejoArchivos.leeFichero("reservas.txt");
            
            // Creacion de los objetos
            //Usuarios
           
            usuarios = ManejoArchivos.genListaUsuarios(a1, a2, a3, a4);

            //Espacios
            espacios = ManejoArchivos.genListaEspacios(a5);

            //Reservas
            reservas = ManejoArchivos.genListaReservas(a6);
    
            //Programa
            mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);

    }
}
