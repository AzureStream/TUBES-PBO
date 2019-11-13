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
    private Menu[] daftarMenu;
    private int numMenu = 0;
    
    public void createMenu(String namaMenu, int hargaMenu){
        this.daftarMenu[numMenu] = new Menu(namaMenu, hargaMenu);
        numMenu++;
    }
}
