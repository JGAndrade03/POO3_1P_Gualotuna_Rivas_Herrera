package proyectopoog3;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;

//librerias para correos
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;


public abstract class Usuario {
    protected String codeUser;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    //protected char rol;

    public Usuario(String codeUser, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo){
        this.codeUser=codeUser;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.correo=correo;
        //this.rol=rol;
       
    }
    

    //Setters de la clase

    public void setCodeUser(String codeUser){
        this.codeUser=codeUser;
    }

    public void setCedula(String cedula){
        this.cedula=cedula;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
    }

    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    

    //Getters de la clase

    public String getCodeUser(){
        return codeUser;
    }

    public String getCedula(){
        return cedula;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContraseña(){
        return contraseña;
    }

    public String getCorreo(){
        return correo;
    }


    
    //Metodos

    public abstract void gestionarReserva(ArrayList<Espacio> espacios, ArrayList<Reserva> reservas);

    public boolean validarCredencial(String usuario, String contraseña){
        return this.usuario.equals(usuario) && this.contraseña.equals(contraseña);
    }

    public abstract void consultarReserva();
    

    public Session iniciarSesion(){
        Dotenv dot = Dotenv.load();

        String host =dot.get("MAIL_HOST");
        String port = dot.get("MAIL_PORT");
        String user = correo;
        String pass = contraseña;   

        Properties prop = new Properties();
        prop.put("mail.smtp.host",host );
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
        });
        return session;
    }

    public void eniarMail(String receptor, Reserva res){}
   

}
// metodo enviar correo completo
// public void enviarMail(String receptor){
//         Dotenv dot = Dotenv.load();

//         String host =dot.get("MAIL_HOST");
//         String port = dot.get("MAIL_PORT");
//         String user = correo;
//         String pass = contraseña;   

//         Properties prop = new Properties();
//         prop.put("mail.smtp.host",host );
//         prop.put("mail.smtp.port", port);
//         prop.put("mail.smtp.auth", true);
//         prop.put("mail.smtp.starttls.enable", true);

//         Session session = Session.getInstance(prop, new Authenticator() {
//             protected PasswordAuthentication getpPasswordAuthentication(){
//                 return new PasswordAuthentication(user, pass);
//             }
//         });

//         try{
//             Message mes = new MimeMessage(session);
//             mes.setFrom(new InternetAddress(user, "APP DE RESERVAS"));
//             mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
//             mes.setSubject("SUJETO DEL CORREO");
//             mes.setText("TEXTO DEL CORREO");
//         }catch(Exception e){
//             System.out.println(e.getMessage());
//         }

//     }