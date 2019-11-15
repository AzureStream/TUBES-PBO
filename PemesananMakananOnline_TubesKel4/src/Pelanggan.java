
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

    public Pelanggan(String nama) {
        super(nama);
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
    
    public void createPesanan(Pengemudi p, Restoran r){
        Pesanan pesan = new Pesanan(p,r);
        daftarPesanan.add(pesan);
    }
}
