
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection con;

    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/tubesPBO";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database");
        } catch (SQLException se) {
            System.out.println("Connection error");
        }
    }

    //Pelanggan
    public void savePelanggan(Pelanggan c) {
        try {
            String query = "insert into pelanggan values('" + c.getIdPelanggan() + "','" + c.getNama() + "','" + c.getPassPelanggan() + "');";
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
            Pelanggan c = null;
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                c = new Pelanggan(id, name, pass);
            }
            return pelanggan;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Pelanggan loadOnePelangganById(String id) {
        try {
            String query = "select * from pelanggan where idPelanggan ='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pelanggan c = null;
            while (rs.next()) {
                String name = rs.getString(2);
                String pass = rs.getString(3);
                c = new Pelanggan(id, name, pass);
            }
            return c;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public Pelanggan cekPelanggan(String id, String pass) {
        try {
            String query = "select * from pelanggan where idPelanggan='" + id + "' and passPelanggan='" + pass + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String idN = rs.getString(1);
            String namaN = rs.getString(2);
            String passN = rs.getString(3);
            Pelanggan c = new Pelanggan(idN,namaN,passN);
            return c;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public ArrayList loadHistoryPelanggan(String id) {
        try {
            ArrayList history = new ArrayList<>();
            String query = "select idOrder from pesanan where idPelanggan='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                history.add(rs.getString(1));
            }
            return history;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Pengemudi
    public void savePengemud(Pengemudi d) {
        try {
            String query = "insert into pengemudi values('" + d.getIdPengemudi()+ "','" + d.getNama() + "','" + d.getPlatNomor()+ "','" + d.getPassPengemudi() + "','"+d.getStatusPengemudi() + "');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException ex) {
            System.out.println("Saving error");
        }
    }

    public ArrayList<Pengemudi> loadAllPengemudi() {
        try {
            ArrayList<Pengemudi> pengemudi = new ArrayList();
            String query = "select * from pengemudi";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pengemudi d = null;
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String plat = rs.getString(4);
                d = new Pengemudi(id, name, plat, pass);
            }
            return pengemudi;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Pengemudi loadOnePengemudiById(String id) {
        try {
            String query = "select * from pengemudi where idPengemudi ='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pengemudi d = null;
            while (rs.next()) {
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String plat = rs.getString(4);
                d = new Pengemudi(id, name, plat, pass);
            }
            return d;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public Pengemudi cekPengemudi(String id, String pass) {
        try {
            String query = "select * from pengemudi where idPengemudi='" + id + "' and passPengemudi='" + pass + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String idN = rs.getString(1);
            String namaN = rs.getString(2);
            String passN = rs.getString(3);
            String platN = rs.getString(4);
            Pengemudi d = new Pengemudi(idN,namaN,platN,passN);
            return d;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public void updateProfil(String id, String nama, String plat) {
        try {
            String query = "update pengemudi set namaPengemudi='" + nama + "' where idPengemudi='"+ id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            query = "update pengemudi set platNomor='" + plat + "' where idPengemudi='"+ id + "';";
            rs = s.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList loadHistoryPengemudi(String id) {
        try {
            ArrayList history = new ArrayList<>();
            String query = "select idOrder from pesanan where idPengemudi='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                history.add(rs.getString(1));
            }
            return history;
        } catch (SQLException ex) {
            return null;
        }
    }

    //Restoran
    public void saveResto(Restoran r) {
        try {
            String query = "insert into restoran values('" + r.getIdRestoran() + "','" + r.getNamaRestoran() + "','" + r.getPassRestoran() + "');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException se) {
            System.out.println("Saving error");
        }
    }

    public ArrayList<Restoran> loadAllResto() {
        try {
            ArrayList<Restoran> resto = new ArrayList();
            String query = "select * from restoran";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Restoran r = null;
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                r = new Restoran(id, name, pass);
                resto.add(r);
            }
            return resto;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public Restoran loadOneRestoranById(String id) {
        try {
            String query = "select * from restoran where idRestoran ='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Restoran r = null;
            while (rs.next()) {
                String name = rs.getString(2);
                String pass = rs.getString(3);
                r = new Restoran(id, name, pass);
            }
            return r;
        } catch (SQLException se) {
            return null;
        }
    }

    public Restoran cekResto(String id, String pass) {
        try {
            String query = "select * from restoran where idRestoran='" + id + "' and passRestoran='" + pass + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String idN, passN;
            if (rs.getString(1) != null && rs.getString(2) != null) {
                idN = rs.getString(1);
                passN = rs.getString(2);
            } else {
                return null;
            }
            Restoran r = new Restoran(idN, passN);
            return r;
        } catch (SQLException se) {
            return null;
        }
    }

    //Menu
    public void saveMenu(String id, String nama, int harga) {
        try {
            String query = "insert into menu values('" + id + "','" + nama + "','" + harga + "');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException se) {
            System.out.println("Saving error");
        }
    }
    
    public void deleteMenu(String id, String nama) {
        try {
            String query = "delete from menu where idRestoran='"+id+"' and namaMenu='"+nama+"';";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Delete success");
        } catch (SQLException se) {
            System.out.println("Delete error");
        }
    }
    
    public void updateMenu(String id, String nama, int harga) {
        try {
            String query = "update menu set hargaMenu="+harga+" where idRestoran='"+id+"' and namaMenu='"+nama+"';";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Update success");
        } catch (SQLException se) {
            System.out.println("Update error");
        }
    }
    
    public void loadAllMenu(String id){
        try {
            ArrayList<Menu> menu = new ArrayList();
            String query = "select namaMenu, hargaMenu from restoran where idRestoran='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                String name=rs.getString(1);
                int harga=Integer.parseInt(rs.getString(2));
                System.out.println("\nNama Menu : "+name+"\nHarga Menu : Rp"+harga);
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
    
    public Menu loadMenu(String id, String name) {
        try {
            String query = "select * from menu where idRestoran ='" + id + "' and namaMenu ='" + name + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Menu m = null;
            while (rs.next()) {
                int harga = Integer.parseInt(rs.getString(2));
                m = new Menu(name, harga);
                m.displayMenu();
            }
            return m;
        } catch (SQLException se) {
            return null;
        }
    }
    
    //Pesanan
    public Pesanan loadOnePesananById(String id) {
        try {
            String query = "select * from pesanan where idOrder ='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pesanan o = null;
            while (rs.next()) {
                String idOrder = rs.getString(1);
                String idPelanggan = rs.getString(2);
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String statusOrder = rs.getString(5);
                String namaMenu = rs.getString(6);
                o = new Pesanan(loadOneRestoranById(idRestoran),loadOnePengemudiById(idPengemudi));
                o.addMenu(new Menu(namaMenu,0));
            }
            return o;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public ArrayList<Pesanan> loadAllPesanan() {
        try {
            ArrayList<Pesanan> pesanan = new ArrayList();
            String query = "select * from pesanan";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pesanan o = null;
            while (rs.next()) {
                String idOrder = rs.getString(1);
                String idPelanggan = rs.getString(2);
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String statusOrder = rs.getString(5);
                String namaMenu = rs.getString(6);
                o = new Pesanan(loadOneRestoranById(idRestoran),loadOnePengemudiById(idPengemudi));
                pesanan.add(o);
            }
            return pesanan;
        } catch (SQLException ex) {
            return null;
        }
    }
}
