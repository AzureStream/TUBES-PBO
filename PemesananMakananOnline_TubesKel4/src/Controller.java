
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        restoHome.addMouseListener(this);
        home.addActionListener(this);
        home.setVisible(true);
        model.loadResto();
        restoLogin.setRestoIdRegister(Restoran.getSid());
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

        //Pelanggan Home
        // ---- Under Construction ----
        
        //Pengemudi Home
        // ---- Under Construction ----
        
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
            restoHome.setListMenu(model.getNamaMenu(idResto));
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
            restoLogin.dispose();
            restoHome.dispose();
            home.setVisible(true);
        }

    }

    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();

        //Pelanggan Home/Pesan/List Resto
        if (source.equals(pelangganHome.getListRestoran())) {
            String id = pelangganHome.getSelectedRestoran();
            pelangganHome.setListMenu(model.getRestoran(id).getListMenu());
        }

        //Pelanggan Home/History
        if (source.equals(pelangganHome.getListHistory())) {
            String id = pelangganHome.getSelectedHistory();
            pelangganHome.setTextDetailHistory(model.getPesanan(id).displayPesanan());
        }

        //Pengemudi Home/History
        if (source.equals(driverHome.getListHistory())) {
            String id = driverHome.getSelectedHistory();
            driverHome.setTextHistory(model.getPesanan(id).displayPesanan());
        }
    }
}
