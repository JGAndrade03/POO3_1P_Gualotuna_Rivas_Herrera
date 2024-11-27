package proyectopoog3;
import java.util.ArrayList;
import java.util.Scanner;

import proyectopoog3.EspacioYReserva.Espacio;
import proyectopoog3.EspacioYReserva.Reserva;
import proyectopoog3.Usuarios.Administrador;
import proyectopoog3.Usuarios.Estudiante;
import proyectopoog3.Usuarios.Profesor;
import proyectopoog3.Usuarios.Usuario;

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
                String eleccion = sc.nextLine();
    

                if(eleccion.equals("1")){
                    est.gestionarReserva(espacios);
                }else if(eleccion.equals("2")){
                    est.consultarReserva(reservas);
                }else if(eleccion.equals("3")){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                    mostrarMenu(user, espacios);
                }
            }else if(user instanceof Profesor){
                Profesor prof = (Profesor) user;
                System.out.println("Bienvenido profesor/a: "+prof.getNombre()+" "+prof.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva\n\t3. Salir");
                System.out.print("Escriba el numero de su eleccion: ");
                String eleccion = sc.nextLine();
                if(eleccion.equals("1")){
                    prof.gestionarReserva(espacios);
                }else if(eleccion.equals("2")){
                    prof.consultarReserva(reservas);
                }else if(eleccion.equals("3")){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                    mostrarMenu(user, espacios);
                }
            }else if(user instanceof Administrador){
                Administrador admin = (Administrador) user;
                System.out.println("Bienvenido administrador/a: "+admin.getNombre()+" "+admin.getApellido());
                System.out.println("¿Desea?\n\t1. Gestionar reservas\n\t2. Consultar Reserva\n\t3. Salir");
                System.out.print("Escriba el numero de su eleccion: ");
                String eleccion = sc.nextLine();
                if(eleccion.equals("1")){
                    admin.gestionarReserva(espacios);
                }else if(eleccion.equals("2")){
                    admin.consultarReserva(reservas);
                }else if(eleccion.equals("3")){
                    mostrarMenu(Reserva.verificarUsuario(usuarios), espacios);
                }else{
                    System.out.println("Error");
                    mostrarMenu(user, espacios);
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