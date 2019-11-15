
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

    public Aplikasi() {
        daftarPelanggan = new ArrayList();
        daftarPengemudi = new ArrayList();
        daftarRestoran = new ArrayList();
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
    
    public void editPengemudi(String idPengemudi){
        Pengemudi p = getPengemudi(idPengemudi);
        p.setNama(idPengemudi);
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
}
