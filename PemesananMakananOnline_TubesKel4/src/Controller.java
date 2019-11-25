import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controller extends MouseAdapter implements ActionListener {
    GUI_Restoran_Login restoLogin;
    GUI_Aplikasi home;
    Aplikasi model;
    
    public Controller(){
        restoLogin = new GUI_Restoran_Login();
        home = new GUI_Aplikasi();
        model = new Aplikasi();
        restoLogin.addRegisterActionListener(this);
        restoLogin.addLoginActionListener(this);
        home.addRestoActionListener(this);
        home.addPelangganActionListener(this);
        home.addDriverActionListener(this);
        home.setVisible(true);
        restoLogin.setRestoIdRegister(Restoran.getSid());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source=ae.getSource();
        if(source.equals(home.getBtnRestoran())){
            restoLogin.setVisible(true);
        }
        if(source.equals(restoLogin.getBtnDaftarResto())){
            try{
                String id = restoLogin.getRestoIdRegister();
                String name = restoLogin.getRestoName();
                String pass = restoLogin.getPassRestoRegister();
                Restoran r = new Restoran(id, name, pass);
                model.addRestoran(r);
                restoLogin.setRestoString(model.searchResto(id));
            }catch (Exception e){
                System.out.println(e);
            }
            restoLogin.resetView();
            restoLogin.setRestoIdRegister(Restoran.getSid());
        } else if(source.equals(restoLogin.getBtnLoginResto())){
            
        }
    }
}
