
import java.util.ArrayList;
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
public class Restoran {
    private String namaRestoran;
    private String idRestoran;
    private List<Menu> daftarMenu;
    private int numMenu = 0;
    private static int sid=1;

    public Restoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
        daftarMenu = new ArrayList();
    }
    
    public Restoran(String idRestoran, String namaRestoran) {
        this.namaRestoran = namaRestoran;
        daftarMenu = new ArrayList();
        this.idRestoran = idRestoran;
        sid++;
    }
    
    public String toString(){
        return "ID: "+idRestoran+"\nName: "+namaRestoran;
    }

    public static int getSid() {
        return sid;
    }
    
    
    public void createMenu(String namaMenu, int hargaMenu){
        this.daftarMenu.add(numMenu, new Menu(namaMenu, hargaMenu));
        numMenu++;
    }

    public String getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(String idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNamaRestoran() {
        return namaRestoran;
    }

    public void setNamaRestoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
    }

    public List<Menu> getDaftarMenu() {
        return daftarMenu;
    }
    
    public Menu getMenu(int i) {
        return daftarMenu.get(i);
    }

    public int getNumMenu() {
        return numMenu;
    }
}
