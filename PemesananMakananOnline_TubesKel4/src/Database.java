
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * -------------------------------- NOTE -------------------------------------
 * TUGAS BESAR PEMROGRAMAN BERORIENTASI OBJEK A 2019/2020
 * KELAS : IF-42-04
 * DIBUAT OLEH :
 * 1. ILHAM RIZKI HIDAYAT (NIM 1301184123)
 * 2. MOCHAMMAD IVAN ADHYAKSA PRADANA (NIM 1301184080)
 * 3. RACHMAT DWI PUTRA (NIM 1301180201)
 * ---------------------------------------------------------------------------
 */
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
                pelanggan.add(c);
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
            Pelanggan c = new Pelanggan(idN, namaN, passN);
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
            while (rs.next()) {
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
            String query = "insert into pengemudi values('" + d.getIdPengemudi() + "','" + d.getNama() + "','" + d.getPassPengemudi() + "','" + d.getPlatNomor() + "','" + d.getStatusPengemudi() + "');";
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
                String status = rs.getString(5);
                d = new Pengemudi(id, name, pass, plat, status);
                pengemudi.add(d);
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
                String status = rs.getString(5);
                d = new Pengemudi(id, name, pass, plat, status);
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
            String status = rs.getString(5);
            Pengemudi d = new Pengemudi(idN, namaN, passN, platN, status);
            return d;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public void updateNotAvailablePengemudi(Pengemudi d) {
        try {
            String query = "update pengemudi set statusPengemudi ='Not available' where idPengemudi='"+d.getIdPengemudi()+"';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("query dieksekusi");
            System.out.println("Update status pengemudi berhasil");
        } catch (SQLException ex) {
            System.out.println("Update status pengemudi gagal");
        }
    }
    
    public void updateAvailablePengemudi(Pengemudi d) {
        try {
            String query = "update pengemudi set statusPengemudi ='Available' where idPengemudi='"+d.getIdPengemudi()+"';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Update status pengemudi berhasil");
        } catch (SQLException ex) {
            System.out.println("Update status pengemudi gagal");
        }
    }

    public void updateProfil(String id, String nama, String plat) {
        try {
            String query = "update pengemudi set namaPengemudi='" + nama + "' where idPengemudi='" + id + "';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            query = "update pengemudi set platNomor='" + plat + "' where idPengemudi='" + id + "';";
            s.executeUpdate(query);
            System.out.println("Update profil pengemudi berhasil");
        } catch (SQLException ex) {
            System.out.println("Update profil pengemudi gagal");
        }
    }

    public ArrayList loadHistoryPengemudi(String id) {
        try {
            ArrayList history = new ArrayList<>();
            String query = "select idOrder from pesanan where idPengemudi='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
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
    
    public Menu loadOneMenu(String id, String nama) {
        try {
            String query = "select hargaMenu from menu where idRestoran ='"+id+"' and namaMenu='"+nama+"';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Menu m = null;
            while(rs.next()) {
                int harga = Integer.parseInt(rs.getString(1));
                m = new Menu(nama,harga);
            }
            return m;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void deleteMenu(String id, String nama) {
        try {
            String query = "delete from menu where idRestoran='" + id + "' and namaMenu='" + nama + "';";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Delete success");
        } catch (SQLException se) {
            System.out.println("Delete error");
        }
    }

    public void updateMenu(String id, String nama, int harga) {
        try {
            String query = "update menu set hargaMenu=" + harga + " where idRestoran='" + id + "' and namaMenu='" + nama + "';";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Update success");
        } catch (SQLException se) {
            System.out.println("Update error");
        }
    }

    public ArrayList<Menu> loadAllMenu(String id) {
        try {
            ArrayList<Menu> menu = new ArrayList();
            String query = "select namaMenu, hargaMenu from menu where idRestoran='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(1);
                int harga = Integer.parseInt(rs.getString(2));
                Menu m = new Menu(name, harga);
                menu.add(m);
            }
            return menu;
        } catch (SQLException se) {
            return null;
        }
    }

    public Menu loadMenu(String id, String name) {
        try {
            String query = "select * from menu where idRestoran ='" + id + "' and namaMenu ='" + name + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Menu m = null;
            while (rs.next()) {
                int harga = Integer.parseInt(rs.getString(3));
                m = new Menu(name, harga);
            }
            return m;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public String infoOneMenu(String id, String name) {
        try {
            String query = "select namaMenu, hargaMenu from menu where idRestoran ='" + id + "' and namaMenu ='" + name + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String m = "Nama Menu : "+rs.getString(1)+" \nHarga Menu : "+rs.getString(2);
            return m;
        } catch (SQLException se) {
            return null;
        }
    }

    //Pesanan
    public void savePesanan(String idPelanggan, Pesanan d) {
        try {
            String query = "insert into pesanan values('" + d.getIdOrder() + "','" + idPelanggan + "','" + d.getPengemudi().getIdPengemudi() + "','"
                    + d.getRestoran().getIdRestoran() + "','" + d.getTotalHarga() + "','" + d.getStatus() + "');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException ex) {
            System.out.println("Saving error");
        }
    }

    public Pesanan loadOnePesananById(String id) {
        try {
            String query = "select * from pesanan where idOrder ='" + id + "';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            Pesanan o = null;
            while (rs.next()) {
                String idOrder = rs.getString(1);
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String totalHarga = rs.getString(5);
                String statusOrder = rs.getString(6);
                o = new Pesanan(idOrder, loadOneRestoranById(idRestoran), loadOnePengemudiById(idPengemudi), Integer.parseInt(totalHarga));
                o.setStatus(statusOrder);
            }
            return o;
        } catch (SQLException se) {
            return null;
        }
    }
    
    public ArrayList<Pesanan> loadAvailablePesanan() {
        try {
            ArrayList<Pesanan> pesanan = new ArrayList<>();
            String query = "select * from pesanan where statusOrder = 'Pesanan dibuat';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String idOrder = rs.getString(1);
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String totalHarga = rs.getString(5);
                String statusOrder = rs.getString(6);
                Pesanan o = new Pesanan(idOrder, loadOneRestoranById(idRestoran), loadOnePengemudiById(idPengemudi), Integer.parseInt(totalHarga));
                o.setStatus(statusOrder);
                pesanan.add(o);
            }
            return pesanan;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Pesanan loadPesananDiambil(String id) {
        try {
            ArrayList<Pesanan> pesanan = new ArrayList<>();
            String query = "select * from pesanan where statusOrder = 'Pesanan diambil' and idPengemudi ='"+id+"';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String idOrder = rs.getString(1);
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String totalHarga = rs.getString(5);
                String statusOrder = rs.getString(6);
                Pesanan o = new Pesanan(idOrder, loadOneRestoranById(idRestoran), loadOnePengemudiById(idPengemudi), Integer.parseInt(totalHarga));
                o.setStatus(statusOrder);
                pesanan.add(o);
            }
            return pesanan.get(0);
        } catch (SQLException ex) {
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
                String idPengemudi = rs.getString(3);
                String idRestoran = rs.getString(4);
                String totalHarga = rs.getString(5);
                String statusOrder = rs.getString(6);
                o = new Pesanan(idOrder, loadOneRestoranById(idRestoran), loadOnePengemudiById(idPengemudi), Integer.parseInt(totalHarga));
                o.setStatus(statusOrder);
                pesanan.add(o);
            }
            return pesanan;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Pengemudi> availablePengemudi() {
        try {
            ArrayList<Pengemudi> pengemudi = new ArrayList();
            String query = "select * from pengemudi where statusPengemudi = 'Available';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String pass = rs.getString(3);
                String plat = rs.getString(4);
                String status = rs.getString(5);
                Pengemudi d = new Pengemudi(id, nama, pass, plat, status);
                pengemudi.add(d);
            }
            return pengemudi;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void updateDiambilPesanan(Pesanan o) {
        try {
            String query = "update pesanan set statusOrder ='Pesanan diambil' where idOrder='"+o.getIdOrder()+"';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Update status pesanan berhasil");
        } catch (SQLException ex) {
            System.out.println("Update status pesanan gagal");
        }
    }
    
    public void updateOtwPesanan(Pesanan o) {
        try {
            String query = "update pesanan set statusOrder ='On the way' where idOrder='"+o.getIdOrder()+"';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Update status pesanan berhasil");
        } catch (SQLException ex) {
            System.out.println("Update status pesanan gagal");
        }
    }
    
    public void updateSelesaiPesanan(Pesanan o) {
        try {
            String query = "update pesanan set statusOrder ='Pesanan selesai' where idOrder ='"+o.getIdOrder()+"';";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Update status pesanan berhasil");
        } catch (SQLException ex) {
            System.out.println("Update status pesanan gagal");
        }
    }

    //Relasi
    public void saveRelasi(String id, String nama) {
        try {
            String query = "insert into relasi_pesanan_menu values('" + id + "','" + nama +"');";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving success");
        } catch (SQLException se) {
            System.out.println("Saving error");
        }
    }
    
    public ArrayList<String> loadRelasiOfOrder(Pesanan o) {
        try {
            ArrayList<String> relasi = new ArrayList();
            String query = "select namaMenu from relasi_pesanan_menu where id_order ='"+o.getIdOrder()+"';";
            Statement s= con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                String namaMenu = rs.getString(1);
                relasi.add(namaMenu);
            }
            return relasi;
        } catch (SQLException ex) {
            return null;
        }
    }
}
