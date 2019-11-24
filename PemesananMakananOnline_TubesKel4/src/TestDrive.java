/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class TestDrive {
    public static void main(String[] args) {
//        Restoran r = new Restoran("Munjul 1");
//        r.createMenu("Ayam Suwir", 7000);
//        r.createMenu("Ayam Goreng", 10000);
//        r.getMenu(0).displayMenu();
////        r.getMenu(0).displayMenu();
//        
//        Pengemudi p = new Pengemudi("F 5354 UBE", "Ilham Rizki");
////        p.displayPengemudi();
//        
////        Pesanan pe = new Pesanan(p, r);
////        pe.addMenu(r.getMenu(0));
////        pe.addMenu(r.getMenu(1));
////        pe.displayPesanan();
//        
////        Pelanggan pl = new Pelanggan("Mamat");
////        pl.getPesanan(0).addMenu(r.getMenu(0));
////        pl.getPesanan(0).displayPesanan();
        Aplikasi a = new Aplikasi();
        a.addPelanggan(new Pelanggan("Berd"));
        a.addPengemudi(new Pengemudi("D 2455 AZ", "Hans"));
        a.addRestoran(new Restoran("Munjul"));
        a.getDaftarRestoran().get(0).createMenu("Cah Kangkung", 7000);
        a.getDaftarRestoran().get(0).displayDaftarMenu(0);
      }
}
