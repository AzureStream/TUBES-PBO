
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class GUI_Restoran extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Restoran
     */
    public GUI_Restoran() {
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
        tfIDRestoran = new javax.swing.JTextField();
        tfNamaRestoran = new javax.swing.JTextField();
        btnDaftarResto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taRestoran1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRestoID = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Resto_Register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nama Restoran :");

        jLabel2.setText("ID Restoran :");

        tfIDRestoran.setEditable(false);
        tfIDRestoran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDRestoranActionPerformed(evt);
            }
        });

        btnDaftarResto.setText("Daftar");

        taRestoran1.setEditable(false);
        taRestoran1.setColumns(20);
        taRestoran1.setRows(5);
        jScrollPane1.setViewportView(taRestoran1);

        jScrollPane2.setViewportView(listRestoID);

        javax.swing.GroupLayout Resto_RegisterLayout = new javax.swing.GroupLayout(Resto_Register);
        Resto_Register.setLayout(Resto_RegisterLayout);
        Resto_RegisterLayout.setHorizontalGroup(
            Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Resto_RegisterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDaftarResto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Resto_RegisterLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNamaRestoran))
                            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIDRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Resto_RegisterLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        Resto_RegisterLayout.setVerticalGroup(
            Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Resto_RegisterLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIDRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNamaRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDaftarResto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(Resto_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register", Resto_Register);

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

    private void tfIDRestoranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDRestoranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDRestoranActionPerformed

    /**
     * @param args the command line arguments
     */
    public String getRestoId(){
        return tfIDRestoran.getText();
    }
    
    public void setRestoId(int id){
        tfIDRestoran.setText("T-"+id);
    }
    
    public String getRestoName(){
        return tfNamaRestoran.getText();
    }
    
    public JButton getBtnDaftarResto(){
        return btnDaftarResto;
    }
    
    public void setListRestoId(String[] listId){
        listRestoID.setListData(listId);
    }
    
    public String getSelectedRestoId(){
        return listRestoID.getSelectedValue();
    }
    
    public void setRestoString(String s){
        taRestoran1.setText(s);
    }
    
    public JList getListRestoId(){
        return listRestoID;
    }
    
    public void addActionListener(ActionListener al){
        btnDaftarResto.addActionListener(al);
    }
    
    public void addMouseAdapter(MouseAdapter ma){
        listRestoID.addMouseListener(ma);
    }
    
    public void resetView(){
        tfNamaRestoran.setText("");
        taRestoran1.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Resto_Register;
    private javax.swing.JButton btnDaftarResto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listRestoID;
    private javax.swing.JTextArea taRestoran1;
    private javax.swing.JTextField tfIDRestoran;
    private javax.swing.JTextField tfNamaRestoran;
    // End of variables declaration//GEN-END:variables
}
