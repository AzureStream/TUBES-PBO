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
public class Menu {
    private String namaMenu;
    private int hargaMenu;

    public Menu(String namaMenu, int hargaMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }
    
    public String getHargaMenuAsString() {
        String s = ""+hargaMenu;
        return s;
    }

    public void setHargaMenu(int hargaMenu) {
        this.hargaMenu = hargaMenu;
    }
    
    public String displayMenu(){
        return "Nama Menu : "+this.getNamaMenu()+"\nHarga Menu : "+this.getHargaMenu();
    }
}
