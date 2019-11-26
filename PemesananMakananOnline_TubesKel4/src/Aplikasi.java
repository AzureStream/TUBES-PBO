
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
    private String idLogin;

    public Aplikasi() {
        daftarPelanggan = new ArrayList();
        daftarPengemudi = new ArrayList();
        daftarRestoran = new ArrayList();
    }

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
    
    public void addPengemudi(Pengemudi p){
        this.daftarPengemudi.add(p);
    }
    
    public Pengemudi getPengemudi(String idPengemudi){
        for (Pengemudi pengemudi : daftarPengemudi) {
            if (pengemudi.getIdPengemudi() == idPengemudi){
                return pengemudi;
            }
        }
        return null;
    }
    
    public void editPengemudi(String idPengemudi, String nama){
        Pengemudi p = getPengemudi(idPengemudi);
        p.setNama(nama);
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
    
    public void addPelanggan(Pelanggan c){
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
    
    public void addRestoran(Restoran r){
        daftarRestoran.add(r);
    }
    
    public Restoran getRestoran(String idRestoran){
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran()== idRestoran){
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
    
    public Restoran searchResto(String id, String pass){
        int i=0;
        while ((i<daftarRestoran.size()) && (daftarRestoran.get(i).getIdRestoran() != id) && (daftarRestoran.get(i).getPassRestoran() != pass)){
            i++;
        }
        return daftarRestoran.get(i);
    }
    
    public Menu searchMenuRestoran(String idRestoran, String namaMenu){
        Restoran r = getRestoran(idRestoran);
        int i = 0;
        while((i<r.getDaftarMenu().size()) && (r.getDaftarMenu().get(i).getNamaMenu() != namaMenu)){
            i++;
        }
        return r.getDaftarMenu().get(i);
    }
    
    public String[] getRestoListId(){
        String[] listId = new String[daftarRestoran.size()];
        for (int i = 0; i < daftarRestoran.size(); i++) {
            listId[i] = daftarRestoran.get(i).getIdRestoran();
        }
        return listId;
    }
    
    public String[] getNamaMenu(Restoran r){
        String[] listMenu = new String[r.getDaftarMenu().size()];
        for (int i = 0; i < r.getDaftarMenu().size(); i++) {
            listMenu[i] = r.getDaftarMenu().get(i).getNamaMenu();
        }
        return listMenu;
    }
    
    public void createMenu(String idRestoran, String namaMenu, int hargaMenu){
        Restoran r = getRestoran(idRestoran);
        r.createMenu(namaMenu, hargaMenu);
    }
    
    public void readMenu(String idRestoran){
        Restoran r = getRestoran(idRestoran);
        for (int j = 0; j < r.getDaftarMenu().size(); j++) {
            r.getDaftarMenu().get(j).displayMenu();
        }
    }
    
    public void updateMenu(String idRestoran, String namaMenuLama, String namaMenuBaru, int hargaMenu){
        Restoran r = getRestoran(idRestoran);
        Menu m = searchMenuRestoran(r.getIdRestoran(), namaMenuLama);
        m.setNamaMenu(namaMenuBaru);
        m.setHargaMenu(hargaMenu);
    }
    
    public void deleteMenu(String idRestoran, String namaMenu){
        Restoran r = getRestoran(idRestoran);
        r.getDaftarMenu().remove(searchMenuRestoran(r.getIdRestoran(), namaMenu));
    }
}
