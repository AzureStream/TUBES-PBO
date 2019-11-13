
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
public class Pesanan {
    private Pengemudi driver;
    private Restoran restoran;
    private List<Menu> menuPesanan = new ArrayList();
    private String status = "Pesanan dibuat";

    public Pesanan(Pengemudi driver, Restoran restoran) {
        addPengemudi(driver);
        addRestoran(restoran);
    }
    
    public void addPengemudi(Pengemudi p){
        this.driver = p;
    }
    
    public void addRestoran(Restoran r){
        this.restoran = r;
    }
    
    public void addMenu(Menu m){
        menuPesanan.add(m);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
