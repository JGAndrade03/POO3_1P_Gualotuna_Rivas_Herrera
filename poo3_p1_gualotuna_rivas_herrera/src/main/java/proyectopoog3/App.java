package proyectopoog3;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
        public static void mostrarMenu(Usuario user){
            Scanner sc = new Scanner(System.in);

            if(user instanceof Estudiante){
                Estudiante est = (Estudiante) user;
                System.out.println("Bienvenido estudiante: "+est.getNombre()+" "+est.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();

                if(eleccion == 1){
                    est.gestionarReserva(null, null);
                }else if(eleccion == 2){
                    est.consultarReserva();
                }else{
                    System.out.println("Error");
                }
            }else if(user instanceof Profesor){
                Profesor prof = (Profesor) user;
                System.out.println("Bienvenido profesor/a: "+prof.getNombre()+" "+prof.getApellido());
                System.out.println("¿Desea?\n\t1. Reservar\n\t2. Consultar Reserva");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();
                if(eleccion == 1){
                    prof.gestionarReserva(null, null);
                }else if(eleccion == 2){
                    prof.consultarReserva();
                }else{
                    System.out.println("Error");
                }
            }else if(user instanceof Administrador){
                Administrador admin = (Administrador) user;
                System.out.println("Bienvenido administrador/a: "+admin.getNombre()+" "+admin.getApellido());
                System.out.println("¿Desea?\n\t1. Gestionar Reservar\n\t2. Consultar Reserva");
                System.out.print("Escriba el numero de su eleccion: ");
                int eleccion = sc.nextInt();
                sc.nextLine();
                if(eleccion == 1){
                    admin.gestionarReserva(null, null);
                }else if(eleccion == 2){
                    admin.consultarReserva();
                }else{
                    System.out.println("Error");
                }

            }sc.close();
        } 
    
        public static void main(String[] args) {
            // Listas de objetos
            ArrayList<Usuario> usuarios = new ArrayList<>();
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            ArrayList<Profesor> profesores = new ArrayList<>();
            ArrayList<Administrador> administradores = new ArrayList<>();
            ArrayList<Espacio> espacios = new ArrayList<>();
            ArrayList<Reserva> reservas = new ArrayList<>();
    
            // Archivos
            ArrayList<String> a1 = ManejoArchivos.leeFichero("usuarios.txt");
            ArrayList<String> a2 = ManejoArchivos.leeFichero("estudiantes.txt");
            ArrayList<String> a3 = ManejoArchivos.leeFichero("profesores.txt");
            ArrayList<String> a4 = ManejoArchivos.leeFichero("administradores.txt");
            ArrayList<String> a5 = ManejoArchivos.leeFichero("espacios.txt");
            ArrayList<String> a6 = ManejoArchivos.leeFichero("reservas.txt");
            
            // Creacion de los objetos
            //Usuarios
            estudiantes = ManejoArchivos.genListaEstudiantes(a1, a2);
            profesores = ManejoArchivos.genListaProfesores(a1, a3);
            administradores = ManejoArchivos.genListaAdministradores(a1, a4);
            usuarios = ManejoArchivos.genListaUsuarios(a1, a2, a3, a4);

            //Espacios
            espacios = ManejoArchivos.genListaEspacios(a5);

            //Reservas
            reservas = ManejoArchivos.genListaReservas(a6);
    
            //Programa
            mostrarMenu(Reserva.verificarUsuario("jperez", "contrasena",usuarios));
        }
    }
