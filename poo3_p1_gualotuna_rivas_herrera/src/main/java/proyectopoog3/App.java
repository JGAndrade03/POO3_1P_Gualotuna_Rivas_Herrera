package proyectopoog3;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Listas de objetos
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Administrador> administradores = new ArrayList<>();
        ArrayList<Espacio> espacios = new ArrayList<>();

        // Archivos
        ArrayList<String> a1 = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> a2 = ManejoArchivos.LeeFichero("estudiantes.txt");
        ArrayList<String> a3 = ManejoArchivos.LeeFichero("profesores.txt");
        ArrayList<String> a4 = ManejoArchivos.LeeFichero("administradores.txt");
        ArrayList<String> a5 = ManejoArchivos.LeeFichero("espacios.txt");
        
        // Creacion de los objetos
        for(String user: a1){
            String[] a_user = user.strip().split("\\|");
            ArrayList<String> l_user = new ArrayList<>();
            for (String elemento : a_user) {
                l_user.add(elemento.strip());
            }
            if(l_user.get(7).equals("E")){
                Usuario usuario = new Estudiante(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null, null);
                for(String est: a2){
                    ArrayList<String> l_estudiante = new ArrayList<>();
                    String[] a_estudiante = est.split("\\|");
                    for (String elemento : a_estudiante) {
                        l_estudiante.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_estudiante.get(0))){
                        Estudiante estudiante = (Estudiante) usuario;
                        estudiante.setMatricula(l_estudiante.get(4));
                        estudiante.setCarrera(l_estudiante.get(5));
                        estudiantes.add(estudiante);
                    }
                }

            }else if(l_user.get(7).equals("P")){
                Usuario usuario = new Profesor(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null, null);
                for(String prof: a3){
                    ArrayList<String> l_profesor = new ArrayList<>();
                    String[] a_profesor = prof.split("\\|");
                    for (String elemento : a_profesor) {
                        l_profesor.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_profesor.get(0))){
                        Profesor profesor = (Profesor) usuario;
                        profesor.setFacultad(l_profesor.get(4));
                        profesor.setMaterias(l_profesor.get(5));
                        profesores.add(profesor);
                    }
                }
            }else if(l_user.get(7).equals("A")){
                Usuario usuario = new Administrador(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null);
                for(String admin: a4){
                    ArrayList<String> l_administrador = new ArrayList<>();
                    String[] a_administrador = admin.split("\\|");
                    for (String elemento : a_administrador) {
                        l_administrador.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_administrador.get(0))){
                        Administrador administrador = (Administrador) usuario;
                        administrador.setCargo(l_administrador.get(4));
                        administradores.add(administrador);
                    }
                }
            }
            
        }

        for(String space: a5){
            String[] a_space = space.strip().split("\\|");
            ArrayList<String> l_space = new ArrayList<>();
            for (String elemento : a_space) {
                l_space.add(elemento.strip());
            }
            int capacidad = Integer.parseInt(l_space.get(3));
            TipoEspacio tipo = TipoEspacio.valueOf(l_space.get(1));
            EstadoEspacio estado = EstadoEspacio.valueOf(l_space.get(4));
            Espacio espacio = new Espacio(l_space.get(0), tipo, l_space.get(2), capacidad, estado, l_space.get(5));
            espacios.add(espacio);
        }
    }
}