
import java.util.*;
import javax.swing.JList;

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
public class Aplikasi {

    private List<Pelanggan> daftarPelanggan;
    private List<Pengemudi> daftarPengemudi;
    private List<Restoran> daftarRestoran;
    private List<Pesanan> daftarPesanan;
    private String idLogin;
    private int totalHarga = 0;
    Database db;

    public Aplikasi() {
        daftarPelanggan = new ArrayList();
        daftarPengemudi = new ArrayList();
        daftarRestoran = new ArrayList();
        daftarPesanan = new ArrayList();
        db = new Database();
        db.connect();
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getIdLogin() {
        return idLogin;
    }

    //List
    public void loadPelanggan() {
        daftarPelanggan = db.loadAllPelanggan();
    }

    public String[] getDaftarPelanggan() {
        String[] listId = new String[daftarPelanggan.size()];
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            listId[i] = daftarPelanggan.get(i).getIdPelanggan();
        }
        return listId;
    }

    public void loadPengemudi() {
        daftarPengemudi = db.loadAllPengemudi();
    }

    public String[] getDaftarPengemudi() {
        String[] listId = new String[daftarPengemudi.size()];
        for (int i = 0; i < daftarPengemudi.size(); i++) {
            listId[i] = daftarPengemudi.get(i).getIdPengemudi();
        }
        return listId;
    }

    public void loadRestoran() {
        daftarRestoran = db.loadAllResto();
    }

    public String[] getDaftarRestoran() {
        String[] listId = new String[daftarRestoran.size()];
        for (int i = 0; i < daftarRestoran.size(); i++) {
            listId[i] = daftarRestoran.get(i).getIdRestoran();
        }
        return listId;
    }

    public void loadPesanan() {
        daftarPesanan = db.loadAllPesanan();
    }

    public String[] getDaftarPesanan() {
        String[] listId = new String[daftarPesanan.size()];
        for (int i = 0; i < daftarPesanan.size(); i++) {
            listId[i] = daftarPesanan.get(i).getIdOrder();
        }
        return listId;
    }

    //Pengemudi
    public void addPengemudi(Pengemudi p) {
        db.savePengemud(p);
    }

    public Pengemudi getPengemudi(String idPengemudi) {
        return db.loadOnePengemudiById(idLogin);
    }

    public void updatePengemudi(String idPengemudi, String nama, String platNomor) {
        db.updateProfil(idPengemudi, nama, platNomor);
    }

    public boolean cekLoginPengemudi(String id, String pass) {
        if (db.cekPengemudi(id, pass) != null) {
            return true;
        }
        return false;
    }

    public String[] getHistoryPengemudi() {
        ArrayList x = db.loadHistoryPengemudi(idLogin);
        String[] history = new String[x.size()];
        int i = 0;
        for (Object o : x) {
            history[i++] = (String) o;
        }
        return history;
    }
    
    public String ambilPesanan() {
        Pengemudi d = db.loadOnePengemudiById(idLogin);
        Pesanan o = null;
        System.out.println("Pengemudi loaded dengan id "+d.getIdPengemudi());        
        ArrayList<Pesanan> pesanan = db.loadAvailablePesanan();
        if (pesanan != null) {
            o = pesanan.get(0);
            db.updateDiambilPesanan(o);
            db.updateNotAvailablePengemudi(d);
        } else {
            o = db.loadPesananDiambil(d.getIdPengemudi());
        }
        return o.getIdOrder();
    }
    
    public void updateStatusAvailable(Pengemudi d) {
        db.updateAvailablePengemudi(d);
    }

    //Pelanggan
    public void addPelanggan(Pelanggan c) {
        db.savePelanggan(c);
    }

    public Pelanggan getPelanggan(String idPelanggan) {
        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan() == idPelanggan) {
                return pelanggan;
            }
        }
        return null;
    }

    public boolean cekLoginPelanggan(String id, String pass) {
        if (db.cekPelanggan(id, pass) != null) {
            return true;
        }
        return false;
    }

    public String[] getHistoryPelanggan() {
        ArrayList x = db.loadHistoryPelanggan(idLogin);
        String[] history = new String[x.size()];
        int i = 0;
        for (Object o : x) {
            history[i++] = (String) o;
        }
        return history;
    }

    //Restoran
    public void addRestoran(Restoran r) {
        db.saveResto(r);
//        daftarRestoran.add(r);
    }

    public Restoran getRestoran(String idRestoran) {
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran() == idRestoran) {
                return restoran;
            }
        }
        return null;
    }

    public Restoran getRestoran(String idRestoran, String pass) {
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran() == idRestoran && restoran.getPassRestoran() == pass) {
                return restoran;
            }
        }
        return null;
    }

    public String searchResto(String id) {
        int i = 0;
        while ((i < daftarRestoran.size()) && (daftarRestoran.get(i).getIdRestoran() != id)) {
            i++;
        }
        return daftarRestoran.get(i).toString();
    }

//    public Restoran cariResto(Restoran r){
//        return db.cekResto(r);
//    }
    public boolean cekResto(String id, String pass) {
        if (db.cekResto(id, pass) != null) {
            return true;
        }
        return false;
    }

    public Menu searchMenuRestoran(String idRestoran, String namaMenu) {
        Restoran r = getRestoran(idRestoran);
        int i = 0;
        while ((i < r.getDaftarMenu().size()) && (r.getDaftarMenu().get(i).getNamaMenu() != namaMenu)) {
            i++;
        }
        return r.getDaftarMenu().get(i);
    }

    public Restoran searchRestoran(String id) {
        return db.loadOneRestoranById(id);
    }

    public Restoran setMenuResto(String id) {
        Restoran r = searchRestoran(id);
        if (r != null) {
            r.setDaftarMenu(db.loadAllMenu(id));
        }
        return r;
    }

    //Pesanan
    public void addPesanan(Pesanan o) {
        db.savePesanan(idLogin, o);
    }
    
    public Pesanan getPesanan(String id) {
        return db.loadOnePesananById(id);
    }
    
    public Pengemudi searchAvailPengemudi() {
        ArrayList<Pengemudi> pengemudi = db.availablePengemudi();       
        Pengemudi p = pengemudi.get(0);
        return p;
    }
    
    public void hitungTotalHarga(int x) {
        totalHarga += x;
    }
    
    public String getTotalHarga() {
        return ""+totalHarga;
    }
    
    public void resetTotalHarga() {
        totalHarga = 0;
    }

    public String displayPesanan(Pesanan o) {
        o.setListMenu(db.loadRelasiOfOrder(o));
        String s = "===============\n"
                +"PESANAN\n"
                +"Nama Restoran: "+o.getRestoran().getNamaRestoran()+"\n"
                +"Menu yang dipesan:\n";
        
        int t = 1;
        for (Object menu : o.getListMenu()) {
            Menu m = db.loadOneMenu(o.getRestoran().getIdRestoran(), menu.toString());
            s += t+". "+m.getNamaMenu()+"\t\tHarga Rp."+m.getHargaMenu()+"\n";
            t++;
        }
        s += "\nTotal harga: Rp "+o.getTotalHarga()+"\n";
        s += "Driver yang mengantar: "+o.getPengemudi().getNama()+" ("+o.getPengemudi().getPlatNomor()+")  ";
        s += "  Status: "+o.getStatus();
        
        return s;
    }
    
    //Pesanan - UpdateStatus
    public void updateDiambil(Pesanan o) {
        db.updateDiambilPesanan(o);
    }
    
    public void updateOtw(Pesanan o) {
        db.updateOtwPesanan(o);
    }
    
    public void updateFinish(Pesanan o) {
        db.updateSelesaiPesanan(o);
    }

    //Menu
    public void getNamaMenu(String idResto) {
        db.loadAllMenu(idResto);
//        Restoran r = getRestoran(idResto);
//        String[] listMenu = r.getListMenu();
//        for (int i = 0; i < r.getDaftarMenu().size(); i++) {
//            listMenu[i] = r.getDaftarMenu().get(i).getNamaMenu();
//        }
//        return listMenu;
//        Restoran r = db.loadOneRestoranById(idResto);
//        String[] listMenu = new String[db.loadAllMenu(r).size()];
//        for (int i = 0; i < db.loadAllMenu(r).size(); i++) {
//            listMenu[i] = db.loadAllMenu(r).get(i).getNamaMenu();
//        }
//        return listMenu;
    }

    public void createMenu(String idRestoran, String namaMenu, int hargaMenu) {
        db.saveMenu(idRestoran, namaMenu, hargaMenu);
        Restoran r = getRestoran(idRestoran);
        r.createMenu(namaMenu, hargaMenu);
    }

    public void readMenu(String idRestoran) {
        Restoran r = getRestoran(idRestoran);
        for (int j = 0; j < r.getDaftarMenu().size(); j++) {
            r.getDaftarMenu().get(j).displayMenu();
        }
    }

    public void updateMenu(String idRestoran, String namaMenu, int hargaMenu) {
        db.updateMenu(idRestoran, namaMenu, hargaMenu);
        Restoran r = getRestoran(idRestoran);
        Menu m = searchMenuRestoran(r.getIdRestoran(), namaMenu);
        m.setHargaMenu(hargaMenu);
    }

    public void deleteMenu(String idRestoran, String namaMenu) {
        db.deleteMenu(idRestoran, namaMenu);
        Restoran r = getRestoran(idRestoran);
        r.getDaftarMenu().remove(searchMenuRestoran(r.getIdRestoran(), namaMenu));
    }
    
    public Menu searchMenu(String idRestoran, String namaMenu) {
        Menu m = db.loadMenu(idRestoran, namaMenu);
        return m;
    }
    
    public String displayMenu(String idRestoran, String namaMenu) {
        String m = db.infoOneMenu(idRestoran, namaMenu);
        return m;
    }
    
    //Relasi Section   
    public void addRelasi(String idOrder, String namaMenu) {
        db.saveRelasi(idOrder, namaMenu);
    }
    
    public String[] getRelasi(Pesanan o) {
        ArrayList<String> r = db.loadRelasiOfOrder(o);
        String[] relasi = new String[r.size()];
        int i = 0;
        for(String s: r) {
            relasi[i++] = s;
        }
        return relasi;
    }

    //ID Generator
    public int newIdPelanggan() {
        if (daftarPelanggan.size() == 0) {
            return 1;
        } else {
            String lastId = daftarPelanggan.get(daftarPelanggan.size() - 1).getIdPelanggan();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId + 1;
        }
    }

    public int newIdPengemudi() {
        if (daftarPengemudi.size() == 0) {
            return 1;
        } else {
            String lastId = daftarPengemudi.get(daftarPengemudi.size() - 1).getIdPengemudi();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId + 1;
        }
    }

    public int newIdResto() {
        if (daftarRestoran.size() == 0) {
            return 1;
        } else {
            String lastId = daftarRestoran.get(daftarRestoran.size() - 1).getIdRestoran();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId + 1;
        }
    }
    
    public int newIdOrder() {
        if(daftarPesanan.size() == 0) {
            return 1;
        } else {
            String lastId = daftarPesanan.get(daftarPesanan.size()-1).getIdOrder();
            String lastNumId = lastId.substring(2,3);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId + 1;
        }
    }
}
