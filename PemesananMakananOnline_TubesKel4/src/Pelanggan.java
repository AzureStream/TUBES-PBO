
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
public class Pelanggan extends Orang {
    private List<Pesanan> daftarPesanan;
    private String idPelanggan;
    private String passPelanggan;
    private static int sid = 1;

    public Pelanggan(String id, String nama, String passPelanggan) {
        super(nama);
        this.idPelanggan = id;
        this.passPelanggan = passPelanggan;
        sid++;
        daftarPesanan = new ArrayList<>();
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }
    
    public Pesanan getPesanan(int i){
        return daftarPesanan.get(i);
    }
    
    public void createPesanan(Restoran r, Pengemudi p){
        Pesanan pesan = new Pesanan(r,p);
        daftarPesanan.add(pesan);
    }

    public String getPassPelanggan() {
        return passPelanggan;
    }

    public void setPassPelanggan(String passPelanggan) {
        this.passPelanggan = passPelanggan;
    }

    public static int getSid() {
        return sid;
    }
}
