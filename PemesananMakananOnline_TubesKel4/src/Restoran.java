
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
    private String passRestoran;
    private List<Menu> daftarMenu;
    private int numMenu = 0;
    private static int sid=1;

    public Restoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
        daftarMenu = new ArrayList();
    }
    
    public Restoran(String idRestoran, String namaRestoran, String passRestoran) {
        this.namaRestoran = namaRestoran;
        daftarMenu = new ArrayList();
        this.idRestoran = idRestoran;
        this.passRestoran = passRestoran;
        sid++;
    }

    public Restoran(String idRestoran, String passRestoran) {
        this.idRestoran = idRestoran;
        this.passRestoran = passRestoran;
        daftarMenu = new ArrayList();
    }
    
    
    public String toString(){
        return "Restoran dengan ID "+idRestoran+" bernama "+namaRestoran+" berhasil didaftarkan";
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

    public String getPassRestoran() {
        return passRestoran;
    }

    public void setPassRestoran(String passRestoran) {
        this.passRestoran = passRestoran;
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
    
    public void setDaftarMenu(ArrayList<Menu> daftarMenu) {
        this.daftarMenu = daftarMenu;
    }
    
    public Menu getMenu(int i) {
        return daftarMenu.get(i);
    }

    public int getNumMenu() {
        return numMenu;
    }
    
    public void displayDaftarMenu(int i){
        getDaftarMenu().get(i).displayMenu();
    }
    
    public String[] getListMenu() {
        String[] menu = new String[daftarMenu.size()];
        int i = 0;
        for (Menu m: daftarMenu) {
            menu[i] = m.getNamaMenu();
            i++;
        }
        return menu;
    }
}
