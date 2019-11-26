import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private Connection con;
    
    public void connect(){
        try{
            String url="jdbc:mysql://localhost:3306/tubesPBO";
            String username="root";
            String password="";
            con=DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database");
        } catch(SQLException se){
            System.out.println("Connection error");
        }
    }
    
    //Pelanggan
    public void savePelanggan(Pelanggan c) {
        try {
            String query = "insert into pelanggan values('"+c.getIdPelanggan()+"','"+c.getNama()+"','"+c.getPassPelanggan()+"');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException ex) {
            System.out.println("Saving error");
        }
    }
    
    public ArrayList<Pelanggan> loadAllPelanggan() {
        try {
            ArrayList<Pelanggan> pelanggan = new ArrayList();
            String query = "select * from pelanggan";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pelanggan c;
            while(rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                c = new Pelanggan(id,name,pass);
            }
            return pelanggan;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Restoran
    public void saveResto(Restoran r){
        try {
            String query = "insert into restoran values('"+r.getIdRestoran()+"','"+r.getNamaRestoran()+"','"+r.getPassRestoran()+"');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException se) {
            System.out.println("Saving error");
        }
    }
    
    public ArrayList<Restoran> loadAllResto(){
        try {
            ArrayList<Restoran> resto = new ArrayList();
            String query = "select * from restoran";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Restoran r;
            while(rs.next()){
                String id=rs.getString(1);
                String name=rs.getString(2);
                String pass=rs.getString(3);
                r=new Restoran(id, name, pass);
                resto.add(r);
            }
            return resto;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public Restoran cekResto(Restoran re){
        try {
            String query = "select * from restoran where idRestoran='" + re.getIdRestoran() + "' and passRestoran='" + re.getPassRestoran() + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String id = rs.getString(1);
            String pass = rs.getString(2);
            Restoran r = new Restoran(id, pass);
            return r;
        } catch (SQLException se) {
            return null;
        }
    }
}
