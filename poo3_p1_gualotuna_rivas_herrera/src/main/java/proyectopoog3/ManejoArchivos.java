package proyectopoog3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManejoArchivos {

    //Metodo de lectura

    public static ArrayList<String> leeFichero(String nombrearchivo){
        ArrayList<String> lines = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            // Apertura del fichero y creacion de BufferedReader para hacer una lectura comoda

            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            //Lectura

            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            //Cerramos fichero para asegurarnos que se cierre tanto por si todo va bien o se salta una excepcion.

            try{
                if(null != fr){
                    fr.close();
                }

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return lines;
    
    }

   

    //ArrayList USUARIOS

    public static ArrayList<Usuario> genListaUsuarios(ArrayList<String> a1, ArrayList<String> a2, ArrayList<String> a3, ArrayList<String> a4){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for(String user: a1){
            String[] a_user = user.strip().split("\\|");
            ArrayList<String> l_user = new ArrayList<>();
            for (String elemento : a_user) {
                l_user.add(elemento.strip());
            }
            if(l_user.get(7).equals("E")){
                Estudiante estudiante = new Estudiante(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null, null);
                for(String est: a2){
                    ArrayList<String> l_estudiante = new ArrayList<>();
                    String[] a_estudiante = est.split("\\|");
                    for (String elemento : a_estudiante) {
                        l_estudiante.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_estudiante.get(0))){
                        estudiante.setMatricula(l_estudiante.get(4));
                        estudiante.setCarrera(l_estudiante.get(5));
                        usuarios.add(estudiante);
                    }
                }

            }else if(l_user.get(7).equals("P")){
                Profesor profesor = new Profesor(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null, null);
                for(String prof: a3){
                    ArrayList<String> l_profesor = new ArrayList<>();
                    String[] a_profesor = prof.split("\\|");
                    for (String elemento : a_profesor) {
                        l_profesor.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_profesor.get(0))){
                        profesor.setFacultad(l_profesor.get(4));
                        profesor.setMaterias(l_profesor.get(5));
                        usuarios.add(profesor);
                    }
                }
            }else if(l_user.get(7).equals("A")){
                Administrador administrador = new Administrador(l_user.get(0), l_user.get(1), l_user.get(2), l_user.get(3), l_user.get(4), l_user.get(5), l_user.get(6), null);
                for(String admin: a4){
                    ArrayList<String> l_administrador = new ArrayList<>();
                    String[] a_administrador = admin.split("\\|");
                    for (String elemento : a_administrador) {
                        l_administrador.add(elemento.strip());
                    }
                    if(l_user.get(0).equals(l_administrador.get(0))){
                        administrador.setCargo(l_administrador.get(4));
                        usuarios.add(administrador);
                    }
                }
            }
            
        }
        return usuarios;
    }

    //ArrayList ESPACIOS

    public static ArrayList<Espacio> genListaEspacios(ArrayList<String> a5){
        ArrayList<Espacio> espacios = new ArrayList<>();
        for(String space: a5){
            String[] a_space = space.strip().split("\\|");
            ArrayList<String> l_space = new ArrayList<>();
            for (String elemento : a_space) {
                l_space.add(elemento.strip());
            }
            int capacidad = Integer.parseInt(l_space.get(3));
            TipoEspacio tipo = TipoEspacio.valueOf(l_space.get(1));
            EstadoEspacio estado = EstadoEspacio.valueOf(l_space.get(4));
            RolesPermitidos permiso = RolesPermitidos.valueOf(l_space.get(5));

            Espacio espacio = new Espacio(l_space.get(0), tipo, l_space.get(2), capacidad, estado, permiso);
            espacios.add(espacio);
        }
        return espacios;

    }
    
    //ArrayList RESERVAS

    public static ArrayList<Reserva> genListaReservas(ArrayList<String> a6){
        ArrayList<Reserva> reservas = new ArrayList<>();
        for(String res : a6){
            String[] a_reserva = res.strip().split("\\|");
            ArrayList<String> l_reserva = new ArrayList<>();
            for(String elemento : a_reserva){
                l_reserva.add(elemento.strip());
            }
            
            TipoEspacio espacio = TipoEspacio.valueOf(l_reserva.get(5));
            EstadoReserva estadoR = EstadoReserva.valueOf(l_reserva.get(6));
            LocalDate fecha = LocalDate.parse(l_reserva.get(3));
            int codReserva = Integer.parseInt(l_reserva.get(0));
            Reserva reserva = new Reserva(codReserva, l_reserva.get(2), fecha, espacio, estadoR, l_reserva.get(7));
            reservas.add(reserva);

        }
        return reservas;
    }


    //METODO DE ESCRITURA


    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
      
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
    

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    
    
}
