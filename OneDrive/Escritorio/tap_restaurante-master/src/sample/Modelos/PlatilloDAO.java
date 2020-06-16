package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Vistas.Platillo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatilloDAO {
    private int idPlatillo;
    private String nombrePlatillo;
    private String descripcionPlatillo;
    private int idCategoria;
    private String imagen;
    private float precio;

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public String getDescripcionPlatillo() {
        return descripcionPlatillo;
    }

    public void setDescripcionPlatillo(String descripcionPlatillo) {
        this.descripcionPlatillo = descripcionPlatillo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImange(String imagen) {
        this.imagen = imagen;
    }

    public ArrayList<PlatilloDAO> seleccionar(int categoria) {

        ArrayList<PlatilloDAO> lista = new ArrayList<PlatilloDAO>();
        PlatilloDAO objPDAO = null;
        String consulta = "SELECT * FROM platillodao WHERE idCategoria = " + categoria;
        try {
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while (res.next()) {
                objPDAO = new PlatilloDAO();
                objPDAO.idPlatillo = res.getInt("idPlatillo");
                objPDAO.nombrePlatillo = res.getString("nombrePlatillo");
                objPDAO.descripcionPlatillo = res.getString("descripcionPlatillo");
                objPDAO.idCategoria = res.getInt("idCategoria");
                objPDAO.imagen = res.getString("imagen");
                objPDAO.precio = res.getFloat("precio");
                lista.add(objPDAO);
            }
        } catch (Exception e) {
            //System.out.println("Error seleccionarPlatillo");
        }

        return lista;
    }

    public PlatilloDAO sPlatillo(int id) {

        PlatilloDAO objPDAO = null;
        String consulta = "SELECT *" +
                "FROM platillodao WHERE idPlatillo = " + id;
        try {
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while (res.next()) {
                objPDAO = new PlatilloDAO();
                objPDAO.idPlatillo = res.getInt("idPlatillo");
                objPDAO.nombrePlatillo = res.getString("nombrePlatillo");
                objPDAO.descripcionPlatillo = res.getString("descripcion");
                objPDAO.idCategoria = res.getInt("idCategoria");
                objPDAO.imagen = res.getString("imagen");
                objPDAO.precio = res.getInt("precio");
            }
        } catch (Exception e) {
            System.out.println("Error sPlatillo");
        }

        return objPDAO;
    }

    public String nombre(int id) {

        PlatilloDAO objPDAO = null;
        String consulta = "SELECT nombrePlatillo FROM platillodao WHERE idPlatillo = " + id;
        try {
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while (res.next()) {
                return res.getString("nombrePlatillo");
            }
        } catch (Exception e) {
            System.out.println("Error nombrePlatillo ");
        }

        return null;
    }

    public void insertar() {
        String query = "INSERT INTO platillodao(" +
                "nombrePlatillo," +
                "precio," +
                "descripcion," +
                "imagen," +
                "idCategoria)" +
                " values(" +
                "'" + nombrePlatillo + "'," +
                precio + "," +
                "'" + descripcionPlatillo + "', " +
                "'" + imagen + "', " +
                idCategoria + ")";
        try{
            Statement stmt = Conexion.con.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e);
        }
    }

    public void actualizar() {
        String query = "UPDATE platillodao SET " +
                "nombrePlatillo = '"+nombrePlatillo+"', " +
                "precio = "+precio+"," +
                "descripcion = '"+descripcionPlatillo+"'," +
                "imagen='"+imagen+"'," +
                "idCategoria="+idCategoria+" " +
                "WHERE" +
                " idPlatillo = "+idPlatillo;
        try{
            Statement stmt = Conexion.con.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public ObservableList<PlatilloDAO> seleccionar() {
        ObservableList<PlatilloDAO> lista = FXCollections.observableArrayList();
        PlatilloDAO objPDAO = null;
        String query = "SELECT * FROM platillodao ORDER BY nombrePlatillo";
        try{
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objPDAO = new PlatilloDAO();
                objPDAO.idPlatillo = res.getInt("idPlatillo");
                objPDAO.nombrePlatillo = res.getString("nombrePlatillo");
                objPDAO.precio = res.getInt("precio");
                objPDAO.descripcionPlatillo = res.getString("descripcion");
                objPDAO.imagen = res.getString("imagen");
                objPDAO.idCategoria = res.getInt("idCategoria");
                lista.add(objPDAO);
            }
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
        return lista;
    }

    public void eliminar() {
        String query = "DELETE FROM platillodao WHERE idPlatillo=" + idPlatillo;
        try{
            Statement stmt = Conexion.con.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }
}

