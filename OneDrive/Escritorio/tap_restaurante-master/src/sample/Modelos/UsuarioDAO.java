package sample.Modelos;

import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String tipo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean iniciar(String nombre, String contra) {
        nombreUsuario = nombre;

        String consulta = "SELECT * " +
                "FROM usuariodao WHERE nombreUsuario = \"" + nombreUsuario + "\"";
        try {
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while (res.next()) {
                idUsuario = res.getInt("idUsuario");
                contraseña = res.getString("contraseña");
                tipo = res.getString("tipo");

                if (res.getString("contraseña").equals(contraseña)) {
                    System.out.println("Contraseaña correcta");
                        return true;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return false;
    }
}