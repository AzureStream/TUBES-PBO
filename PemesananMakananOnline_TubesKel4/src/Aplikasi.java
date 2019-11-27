
import java.util.*;

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
    Database db;

    public Aplikasi() {
        daftarPelanggan = new ArrayList();
        daftarPengemudi = new ArrayList();
        daftarRestoran = new ArrayList();
        db=new Database();
        db.connect();
    }
    
    //List
    public String[] getDaftarPelanggan() {
        String[] listId = new String[daftarPelanggan.size()];
        for (int i=0; i<daftarPelanggan.size(); i++) {
            listId[i] = daftarPelanggan.get(i).getIdPelanggan();
        }
        return listId;    
    }

    public String[] getDaftarPengemudi() {
        String[] listId = new String[daftarPengemudi.size()];
        for (int i=0; i<daftarPengemudi.size(); i++) {
            listId[i] = daftarPengemudi.get(i).getIdPengemudi();
        }
        return listId;
    }

    public String[] getDaftarRestoran() {
        String[] listId = new String[daftarRestoran.size()];
        for (int i=0; i<daftarRestoran.size(); i++) {
            listId[i] = daftarRestoran.get(i).getIdRestoran();
        }
        return listId;
    }

    public String[] getDaftarPesanan() {
        String[] listId = new String[daftarPesanan.size()];
        for (int i=0; i<daftarPesanan.size(); i++) {
            listId[i] = daftarPesanan.get(i).getIdOrder();
        }
        return listId;
    }
    
    //Pengemudi
    public void addPengemudi(Pengemudi p){
        db.savePengemud(p);
        daftarPengemudi.add(p);
    }
    
    public Pengemudi getPengemudi(String idPengemudi){
        for (Pengemudi pengemudi : daftarPengemudi) {
            if (pengemudi.getIdPengemudi() == idPengemudi){
                return pengemudi;
            }
        }
        return null;
    }
    
    public void updatePengemudi(String idPengemudi, String nama, String platNomor){
        Pengemudi p = getPengemudi(idPengemudi);
        p.setNama(nama);
        p.setPlatNomor(platNomor);
    }
    
    public Pengemudi searchAvailPengemudi(){
        Pengemudi p = null;
        int i = 0;
        do {
            p = daftarPengemudi.get(i);
            i++;
        } while(!p.getStatusPengemudi().equals("Available") && i<daftarPengemudi.size());
        if(p.getStatusPengemudi().equals("Available")){
            return p;
        } else {
            return null;
        }
    }
    
    public boolean cekLoginPengemudi(String id, String pass) {
        if (db.cekPengemudi(id, pass) != null){
            return true;
        }
        return false;
    }
    
    //Pelanggan
    public void addPelanggan(Pelanggan c){
        db.savePelanggan(c);
        daftarPelanggan.add(c);
    }
    
    public Pelanggan getPelanggan(String idPelanggan){
        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan() == idPelanggan){
                return pelanggan;
            }
        }
        return null;
    }
    
    public boolean cekLoginPelanggan(String id, String pass) {
        if (db.cekPelanggan(id, pass) != null){
            return true;
        }
        return false;
    }
    
    //Restoran
    public void addRestoran(Restoran r){
        db.saveResto(r);
        daftarRestoran.add(r);
    }
    
    public void loadResto(){
        daftarRestoran=db.loadAllResto();
    }
    
    public Restoran getRestoran(String idRestoran){
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran()== idRestoran){
                return restoran;
            }
        }
        return null;
    }
    
    public Restoran getRestoran(String idRestoran, String pass){
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran()== idRestoran && restoran.getPassRestoran()== pass){
                return restoran;
            }
        }
        return null;
    }
    
    public String searchResto(String id){
        int i=0;
        while ((i<daftarRestoran.size()) && (daftarRestoran.get(i).getIdRestoran() != id)){
            i++;
        }
        return daftarRestoran.get(i).toString();
    }
    
//    public Restoran cariResto(Restoran r){
//        return db.cekResto(r);
//    }
    
    public boolean cekResto(String id, String pass) {
        if (db.cekResto(id, pass) != null){
            return true;
        }
        return false;
    }
    
    public Menu searchMenuRestoran(String idRestoran, String namaMenu){
        Restoran r = getRestoran(idRestoran);
        int i = 0;
        while((i<r.getDaftarMenu().size()) && (r.getDaftarMenu().get(i).getNamaMenu() != namaMenu)){
            i++;
        }
        return r.getDaftarMenu().get(i);
    }
    
    //Pesanan
    public Pesanan getPesanan(String id) {
        for (Pesanan o: daftarPesanan) {
            if (o.getIdOrder() == id) {
                return o;
            }
        }
        return null;
    }
    
    //Menu
    public String[] getNamaMenu(String idResto){
        Restoran r = getRestoran(idResto);
        String[] listMenu = r.getListMenu();
//        for (int i = 0; i < r.getDaftarMenu().size(); i++) {
//            listMenu[i] = r.getDaftarMenu().get(i).getNamaMenu();
//        }
        return listMenu;
//        Restoran r = db.loadOneRestoranById(idResto);
//        String[] listMenu = new String[db.loadAllMenu(r).size()];
//        for (int i = 0; i < db.loadAllMenu(r).size(); i++) {
//            listMenu[i] = db.loadAllMenu(r).get(i).getNamaMenu();
//        }
//        return listMenu;
    }
    
    public void createMenu(String idRestoran, String namaMenu, int hargaMenu){
        db.saveMenu(idRestoran, namaMenu, hargaMenu);
        Restoran r = getRestoran(idRestoran);
        r.createMenu(namaMenu, hargaMenu);
    }
    
    public void readMenu(String idRestoran){
        Restoran r = getRestoran(idRestoran);
        for (int j = 0; j < r.getDaftarMenu().size(); j++) {
            r.getDaftarMenu().get(j).displayMenu();
        }
    }
    
    public void updateMenu(String idRestoran, String namaMenu, int hargaMenu){
        db.updateMenu(idRestoran, namaMenu, hargaMenu);
        Restoran r = getRestoran(idRestoran);
        Menu m = searchMenuRestoran(r.getIdRestoran(), namaMenu);
        m.setHargaMenu(hargaMenu);
    }
    
    public void deleteMenu(String idRestoran, String namaMenu){
        db.deleteMenu(idRestoran, namaMenu);
        Restoran r = getRestoran(idRestoran);
        r.getDaftarMenu().remove(searchMenuRestoran(r.getIdRestoran(), namaMenu));
    }
    
    //ID Generator
    public int newIdPelanggan() {
        if(daftarPelanggan.size()==0) {
            return 1;
        } else {
            String lastId = daftarPelanggan.get(daftarPelanggan.size()-1).getIdPelanggan();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId+1;
        }
    }
    
    public int newIdPengemudi() {
        if(daftarPengemudi.size()==0) {
            return 1;
        } else {
            String lastId = daftarPengemudi.get(daftarPengemudi.size()-1).getIdPengemudi();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId+1;
        }
    }
    
    public int newIdResto(){
        if(daftarRestoran.size()==0){
            return 1;
        }else{
            String lastId = daftarRestoran.get(daftarRestoran.size()-1).getIdRestoran();
            String lastNumId = lastId.substring(2);
            int lastNoId = Integer.parseInt(lastNumId);
            return lastNoId+1;
        }
    }
}
