
import java.util.List;

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
public class Pesanan {
    private Pengemudi driver;
    private Restoran restoran;
    private List<Menu> menuPesanan;
    private String status;

    public void addPengemudi(Pengemudi p){
        this.driver = p;
    }
    
    public void addRestoran(Restoran r){
        this.restoran = r;
    }
    
    public void addMenu(Menu m){
        this.menuPesanan.add(m);
    }
}
