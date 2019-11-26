
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
                if (!model.cekResto(id,pass)) {
                    restoHome.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "ID/Password salah");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        // Button RestoHome
        if (source.equals(restoHome.getBtnCreateMenu())) {
            try {
                String idResto = restoLogin.getRestoIdLogin();
                String nama = restoHome.getNamaMenu();
                int harga = restoHome.getHargaMenu();
                model.createMenu(idResto, nama, harga);
            } catch (Exception e) {
                System.out.println(e);
            }
            restoHome.resetView();
//            restoHome.setListMenu(model.getNamaMenu(r));
            JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan");
        }

    }
}
