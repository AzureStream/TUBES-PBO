
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class GUI_Restoran_Login extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Restoran
     */
    public GUI_Restoran_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Resto_Register = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfIDRestoranRegister = new javax.swing.JTextField();
        tfNamaRestoran = new javax.swing.JTextField();
        btnDaftarResto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pfPasswordRestoRegister = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pfPasswordRestoLogin = new javax.swing.JPasswordField();
        tfIDRestoLogin = new javax.swing.JTextField();
        btnRestoLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Resto_Register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nama Restoran :");

        jLabel2.setText("Password :");

        tfIDRestoranRegister.setEditable(false);
        tfIDRestoranRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDRestoranRegisterActionPerformed(evt);
            }
        });

        btnDaftarResto.setText("Daftar");
        btnDaftarResto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarRestoActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Restoran :");

        taResto.setEditable(false);
        taResto.setColumns(20);
        taResto.setRows(5);
        jScrollPane1.setViewportView(taResto);

        javax.swing.GroupLayout Resto_RegisterLayout = new javax.swing.GroupLayout(Resto_Register);
        Resto_Register.setLayout(Resto_RegisterLayout);
        Resto_RegisterLayout.setHorizontalGroup(
            Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Resto_RegisterLayout.createSequentialGroup()
                        .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNamaRestoran)
                            .addComponent(pfPasswordRestoRegister)))
                    .addGroup(Resto_RegisterLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIDRestoranRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(161, 161, 161))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Resto_RegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDaftarResto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Resto_RegisterLayout.setVerticalGroup(
            Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIDRestoranRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNamaRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfPasswordRestoRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDaftarResto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Register", Resto_Register);

        jLabel4.setText("ID Restoran");

        jLabel5.setText("Password");

        btnRestoLogin.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfPasswordRestoLogin)
                    .addComponent(tfIDRestoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestoLogin)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfIDRestoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pfPasswordRestoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(btnRestoLogin)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIDRestoranRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDRestoranRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDRestoranRegisterActionPerformed

    private void btnDaftarRestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarRestoActionPerformed
        
    }//GEN-LAST:event_btnDaftarRestoActionPerformed

    /**
     * @param args the command line arguments
     */
    public String getRestoIdRegister() {
        return tfIDRestoranRegister.getText();
    }

    public void setRestoIdRegister(int id) {
        tfIDRestoranRegister.setText("R-" + id);
    }

    public String getRestoName() {
        return tfNamaRestoran.getText();
    }

    public String getPassRestoRegister() {
        return pfPasswordRestoRegister.getText();
    }

    public String getRestoIdLogin() {
        return tfIDRestoLogin.getText();
    }

    public String getPassRestoLogin() {
        return pfPasswordRestoLogin.getText();
    }

    public JButton getBtnLoginResto() {
        return btnRestoLogin;
    }

    public JButton getBtnDaftarResto() {
        return btnDaftarResto;
    }

    public void addActionListener(ActionListener al) {
        btnDaftarResto.addActionListener(al);
        btnRestoLogin.addActionListener(al);
    }

    public void resetView() {
        tfNamaRestoran.setText("");
        pfPasswordRestoRegister.setText("");
    }
    
    public void setRestoString(String s){
        taResto.setText(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Resto_Register;
    private javax.swing.JButton btnDaftarResto;
    private javax.swing.JButton btnRestoLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField pfPasswordRestoLogin;
    private javax.swing.JPasswordField pfPasswordRestoRegister;
    private javax.swing.JTextArea taResto;
    private javax.swing.JTextField tfIDRestoLogin;
    private javax.swing.JTextField tfIDRestoranRegister;
    private javax.swing.JTextField tfNamaRestoran;
    // End of variables declaration//GEN-END:variables
}
