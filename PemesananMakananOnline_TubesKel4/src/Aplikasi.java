
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
    private List<Pelanggan> daftarPelanggan = new ArrayList();
    private List<Pengemudi> daftarPengemudi = new ArrayList();
    private List<Restoran> daftarRestoran = new ArrayList();
    
    public void addPengemudi(Pengemudi p){
        this.daftarPengemudi.add(p);
    }
    
    public void addPelanggan(Pelanggan c){
        daftarPelanggan.add(c);
    }
    
    public void addRestoran(Restoran r){
        daftarRestoran.add(r);
    }
}
