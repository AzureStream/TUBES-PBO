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
public class Pengemudi extends Orang {
    private String platNomor;
    private String idPengemudi;
    private String statusPengemudi = "Available";
    private String passPengemudi;
    private static int sid = 1;

    public Pengemudi(String platNomor, String nama, String passPengemudi) {
        super(nama);
        this.idPengemudi = "T-"+sid;
        sid++;
        this.platNomor = platNomor;
        this.passPengemudi = passPengemudi;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getIdPengemudi() {
        return idPengemudi;
    }

    public String getStatusPengemudi() {
        return statusPengemudi;
    }

    public void setStatusPengemudi(String status) {
        this.statusPengemudi = status;
    }
    
    public void displayPengemudi(){
        System.out.println("Nama: "+this.getNama());
        System.out.println("Plat Nomor: "+this.getPlatNomor());
    }
}
