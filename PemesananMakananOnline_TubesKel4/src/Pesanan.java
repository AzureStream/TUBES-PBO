
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
    private String idOrder;
    private Pengemudi driver;
    private Restoran restoran;
    private List<Menu> menuPesanan = new ArrayList();
    private String status = "Pesanan dibuat";
    private static int sid = 1;

    public Pesanan(Restoran restoran, Pengemudi pengemudi) {
        addPengemudi(pengemudi);
        addRestoran(restoran);
        this.idOrder = "O-"+sid;
        sid++;
    }
    
    public Pesanan(String id, Restoran restoran, Pengemudi pengemudi) {
        addPengemudi(pengemudi);
        addRestoran(restoran);
        idOrder = id;
    }
    
    public void addPengemudi(Pengemudi p){
        this.driver = p;
    }
    
    public Pengemudi getPengemudi() {
        return driver;
    }
    
    public void addRestoran(Restoran r){
        this.restoran = r;
    }
    
    public Restoran getRestoran() {
        return restoran;
    }
    
    public void setListMenu(ArrayList x) {
        menuPesanan = x;
    }
    
    public ArrayList getListMenu() {
        return (ArrayList) menuPesanan;
    }

    public String getIdOrder() {
        return idOrder;
    }
    
    public void addMenu(Menu m){
        menuPesanan.add(m);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public String displayPesanan(){
        String s = "===============\n"
                +"PESANAN\n"
                +"Nama Restoran: "+this.restoran.getNamaRestoran()+"\n"
                +"Menu yang dipesan:\n";
        
        int t = 1;
        for (Menu menu : menuPesanan) {
            s += t+". "+menu.getNamaMenu()+"\t\tHarga Rp."+menu.getHargaMenu()+"\n";
            t++;
        }
        s += "Driver yang mengantar: "+this.driver.getNama()+" ("+this.driver.getPlatNomor()+")  ";
        s += "  Status: "+getStatus();
        
        return s;
    }
}
