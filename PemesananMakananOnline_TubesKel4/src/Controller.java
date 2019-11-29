
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller extends MouseAdapter implements ActionListener {

    GUI_Restoran_Login restoLogin;
    GUI_Restoran_Home restoHome;
    GUI_Pelanggan_Login pelangganLogin;
    GUI_Pelanggan_Home pelangganHome;
    GUI_Pengemudi_Login driverLogin;
    GUI_Pengemudi_Home driverHome;
    GUI_Aplikasi home;
    Aplikasi model;
    List keranjang;

    public Controller() {
        restoLogin = new GUI_Restoran_Login();
        restoHome = new GUI_Restoran_Home();
        pelangganLogin = new GUI_Pelanggan_Login();
        pelangganHome = new GUI_Pelanggan_Home();
        driverLogin = new GUI_Pengemudi_Login();
        driverHome = new GUI_Pengemudi_Home();
        home = new GUI_Aplikasi();
        model = new Aplikasi();
        restoLogin.addActionListener(this);
        restoHome.addActionListener(this);
        restoHome.addMouseAdapter(this);
        pelangganLogin.addActionListener(this);
        pelangganLogin.addMouseListener(this);
        pelangganHome.addActionListener(this);
        pelangganHome.addMouseAdapter(this);
        driverLogin.addActionListener(this);
        driverLogin.addMouseListener(this);
        driverHome.addActioinListener(this);
        driverHome.addMouseAdapter(this);
        home.addActionListener(this);
        home.setVisible(true);
        model.loadPelanggan();
        model.loadPengemudi();
        model.loadRestoran();
        model.loadPesanan();
        restoLogin.setRestoIdRegister(model.newIdResto());
        pelangganLogin.setIdRegister(model.newIdPelanggan());
        driverLogin.setIdRegister(model.newIdPengemudi());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        // Button Home
        if (source.equals(home.getBtnRestoran())) {
            restoLogin.setVisible(true);
            home.dispose();
        } else if (source.equals(home.getBtnPelanggan())) {
            pelangganLogin.setVisible(true);
            home.dispose();
        } else if (source.equals(home.getBtnDriver())) {
            driverLogin.setVisible(true);
            home.dispose();
        }

        //Pelanggan Register/Login
        //Register
        if (source.equals(pelangganLogin.getBtnDaftarPelanggan())) {
            try {
                String id = pelangganLogin.getIdRegister();
                String nama = pelangganLogin.getNama();
                String pass = pelangganLogin.getPassRegister();
                Pelanggan c = new Pelanggan(id,nama,pass);
                model.addPelanggan(c);
                model.loadPelanggan();
                pelangganLogin.setTextRegister("Pembuatan akun berhasil.\n"
                        + "Terimakasih telah mendaftar "+nama+".");
            } catch(Exception e) {
                pelangganLogin.setTextRegister("Pembuatan akun gagal.");
            }
            pelangganLogin.resetView();
            pelangganLogin.setIdRegister(Pelanggan.getSid());
        }
        //Login
        if (source.equals(pelangganLogin.getBtnLoginPelanggan())) {
            Pelanggan c = null;
            try {
                String id = pelangganLogin.getIdLogin();
                String pass = pelangganLogin.getPassLogin();
                if (!model.cekLoginPelanggan(id,pass)) {
                    pelangganLogin.dispose();
                    pelangganHome.setVisible(true);
                    model.setIdLogin(id);
                    pelangganHome.setListRestoran(model.getDaftarRestoran());
                    pelangganHome.setListHistory(model.getHistoryPelanggan());
                    keranjang = new ArrayList<>();
                } else {
                    JOptionPane.showMessageDialog(null, "ID/Password salah");
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        //Kembali
        if (source.equals(pelangganLogin.getBtnKembali())||source.equals(pelangganLogin.getBtnKembaliLogin())) {
            pelangganLogin.dispose();
            home.setVisible(true);
        }
        
        //Pelanggan Home
        //Pesan
        if (source.equals(pelangganHome.getBtnAddKeranjang())) {
            keranjang.add(pelangganHome.getSelectedMenu());
            String[] daftarKeranjang = new String[keranjang.size()];
            int i = 0;
            for (Object o: keranjang) {
                daftarKeranjang[i++] = o.toString();
            }
            pelangganHome.setListKeranjang(daftarKeranjang);
        }
        
        if (source.equals(pelangganHome.getBtnPesan())) {
            Pesanan o = new Pesanan("O-"+model.newIdOrder(),model.searchRestoran(pelangganHome.getSelectedRestoran()),model.searchAvailPengemudi());
            model.addPesanan(o);
            model.loadPesanan();
            for (Object p: keranjang) {
                model.addRelasi(o.getIdOrder(), p.toString());
            }
            pelangganHome.setListHistory(model.getHistoryPelanggan());
            keranjang.clear();
        }
        
        //History
        //It's in Mouse Adapter
        
        //Logout
        if (source.equals(pelangganHome.getBtnLogout())) {
            model.setIdLogin("");
            pelangganHome.dispose();
            pelangganLogin.setVisible(true);
        }
        
        //Pengemudi Register/Login
        //Register
        if (source.equals(driverLogin.getBtnDaftar())) {
            try {
                String id = driverLogin.getIdRegister();
                String nama = driverLogin.getNama();
                String plat = driverLogin.getPlatNomor();
                String pass = driverLogin.getPassRegister();
                String status = "Available";
                Pengemudi d = new Pengemudi(id,nama,plat,pass,status);
                model.addPengemudi(d);
                driverLogin.setTextRegister("Pembuatan akun berhasil.\n"
                        + "Terimakasih telah mendaftar "+nama+".");
            } catch(Exception e) {
                driverLogin.setTextRegister("Pembuatan akun gagal.");
            }
            driverLogin.resetView();
            driverLogin.setIdRegister(Pengemudi.getSid());
        }
        //Login
        if (source.equals(driverLogin.getBtnLogin())) {
            Pengemudi d = null;
            try {
                String id = driverLogin.getIdLogin();
                String pass = driverLogin.getPassLogin();
                if (!model.cekLoginPengemudi(id,pass)) {
                    driverLogin.dispose();
                    driverHome.setVisible(true);
                    model.setIdLogin(id);
                    driverHome.setListHistory(model.getHistoryPengemudi());
                } else {
                    JOptionPane.showMessageDialog(null, "ID/Password salah");
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        //Kembali
        if (source.equals(driverLogin.getBtnKembali())) {
            driverLogin.dispose();
            home.setVisible(true);
        }
        
        //Pengemudi Home
        //Ambil Pesanan
        
        //Edit Profil
        if (source.equals(driverHome.getBtnSimpan())) {
            String id = model.getIdLogin();
            String nama = driverHome.getNamaBaru();
            String plat = driverHome.getPlatBaru();
            model.updatePengemudi(id, nama, plat);
            driverHome.setTextEditProfil("Profil berhasil diperbarui");
        }
        
        //History
        //It's in Mouse Adapter
        
        // Logout
        if (source.equals(driverHome.getBtnLogout())) {
            model.setIdLogin("");
            driverHome.dispose();
            driverLogin.setVisible(true);
        }
        
        // Button RestoLogin
        if (source.equals(restoLogin.getBtnDaftarResto())) {
            try {
                String id = restoLogin.getRestoIdRegister();
                String name = restoLogin.getRestoName();
                String pass = restoLogin.getPassRestoRegister();
                Restoran r = new Restoran(id, name, pass);
                model.addRestoran(r);
                restoLogin.setRestoString(model.searchResto(id));
            } catch (Exception e) {
                System.out.println(e);
            }
            restoLogin.resetView();
            restoLogin.setRestoIdRegister(Restoran.getSid());
        }
        if (source.equals(restoLogin.getBtnLoginResto())) {
            Restoran r = null;
            try {
                String id = restoLogin.getRestoIdLogin();
                String pass = restoLogin.getPassRestoLogin();
                if (!model.cekResto(id, pass)) {
                    restoHome.setVisible(true);
                    model.setIdLogin(id);
                } else {
                    JOptionPane.showMessageDialog(null, "ID/Password salah");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (source.equals(restoLogin.getBtnHome())) {
            restoLogin.dispose();
            home.setVisible(true);
        }
        // Button RestoHome
        if (source.equals(restoHome.getBtnCreateMenu())) {
            String idResto = restoLogin.getRestoIdLogin();
            try {
                String nama = restoHome.getNamaMenu();
                int harga = restoHome.getHargaMenu();
                model.createMenu(idResto, nama, harga);
            } catch (Exception e) {
                System.out.println(e);
            }
            restoHome.resetView();
            JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan");
//            restoHome.setListMenu(model.getNamaMenu(idResto));
//            restoHome.daftarMenu(model.getNamaMenu(idResto));
        }
        if (source.equals(restoHome.getBtnDeleteMenu())) {
            String idResto = restoLogin.getRestoIdLogin();
            try {
                String nama = restoHome.getNamaMenu();
                int harga = restoHome.getHargaMenu();
                model.deleteMenu(idResto, nama);
            } catch (Exception e) {
                System.out.println(e);
            }
            restoHome.resetView();
            JOptionPane.showMessageDialog(null, "Menu berhasil dihapus");
        }
        if (source.equals(restoHome.getBtnUpdateMenu())) {
            String idResto = restoLogin.getRestoIdLogin();
            try {
                String nama = restoHome.getNamaMenu();
                int harga = restoHome.getHargaMenu();
                model.updateMenu(idResto, nama, harga);
            } catch (Exception e) {
                System.out.println(e);
            }
            restoHome.resetView();
            JOptionPane.showMessageDialog(null, "Harga menu berhasil diupdate");
        }
        if (source.equals(restoHome.getBtnHome())) {
            restoLogin.resetView();
            restoHome.dispose();
            restoLogin.setVisible(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();

        //Pelanggan Home/Pesan/List Resto
        if (source.equals(pelangganHome.getListRestoran())) {
            String id = pelangganHome.getSelectedRestoran();
            pelangganHome.setListMenu(model.setMenuResto(id).getListMenu());
        }
        
        //Pelanggan Home/Pesan/List Menu
        if (source.equals(pelangganHome.getListMenu())) {
            String id = pelangganHome.getSelectedRestoran();
            String nama = pelangganHome.getSelectedMenu();
            Menu m = model.searchMenu(id, nama);
            pelangganHome.setHarga(m.getHargaMenuAsString());
        }

        //Pelanggan Home/History
        if (source.equals(pelangganHome.getListHistory())) {
            String id = pelangganHome.getSelectedHistory();
            pelangganHome.setTextDetailHistory(model.searchPesanan(id).displayPesanan());
        }

        //Pengemudi Home/History
        if (source.equals(driverHome.getListHistory())) {
            String id = driverHome.getSelectedHistory();
            driverHome.setTextHistory(model.searchPesanan(id).displayPesanan());
        }
        
        //Restoran Menu
        if (source.equals(restoHome.getListNamaMenu())) {
            String id = restoLogin.getRestoIdLogin();
            restoHome.setListMenu(model.setMenuResto(id).getListMenu());
        }
    }
}
