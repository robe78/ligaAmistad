/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import sources.GestionarEquipos;
import sources.MostrarDatos;

/**
 *
 * @author rob_a
 */
public class AgregarEquipo extends javax.swing.JDialog {

    private final MostrarDatos md = new MostrarDatos();
    private final GestionarEquipos ge = new GestionarEquipos();

    /**
     * Creates new form EditarCampo
     */
    public AgregarEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(232, 245, 228));
        
        md.llenarComboCategorias(this.cbAgregarEquipoCategoria);
        md.llenarComboDivisiones(this.cbAgregarEquipoDivision);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogoAgregarEquipo = new javax.swing.JLabel();
        txtAgregarEquipo = new javax.swing.JTextField();
        cbAgregarEquipoCategoria = new javax.swing.JComboBox<>();
        cbAgregarEquipoDivision = new javax.swing.JComboBox<>();
        btnAgregarEquipo = new javax.swing.JButton();
        btnCancelarEquipo = new javax.swing.JButton();
        lblAgreagarEquipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar equipo");
        setBackground(new java.awt.Color(0, 0, 0));

        lblLogoAgregarEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/equipos_menu.png"))); // NOI18N

        cbAgregarEquipoCategoria.setBackground(new java.awt.Color(31, 87, 12));
        cbAgregarEquipoCategoria.setForeground(new java.awt.Color(255, 255, 255));
        cbAgregarEquipoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoría" }));

        cbAgregarEquipoDivision.setBackground(new java.awt.Color(31, 87, 12));
        cbAgregarEquipoDivision.setForeground(new java.awt.Color(255, 255, 255));
        cbAgregarEquipoDivision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una división" }));

        btnAgregarEquipo.setBackground(new java.awt.Color(31, 87, 12));
        btnAgregarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEquipo.setText("Aceptar");
        btnAgregarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoActionPerformed(evt);
            }
        });

        btnCancelarEquipo.setBackground(new java.awt.Color(31, 87, 12));
        btnCancelarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarEquipo.setText("Cancelar");
        btnCancelarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEquipoActionPerformed(evt);
            }
        });

        lblAgreagarEquipo.setBackground(new java.awt.Color(31, 87, 12));
        lblAgreagarEquipo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        lblAgreagarEquipo.setForeground(new java.awt.Color(31, 87, 12));
        lblAgreagarEquipo.setText("Seleccione un equipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogoAgregarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgreagarEquipo)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(txtAgregarEquipo)
                    .addComponent(cbAgregarEquipoCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAgregarEquipoDivision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoAgregarEquipo)
                    .addComponent(lblAgreagarEquipo))
                .addGap(18, 18, 18)
                .addComponent(txtAgregarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbAgregarEquipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbAgregarEquipoDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarEquipo)
                    .addComponent(btnAgregarEquipo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoActionPerformed
            String nombre = txtAgregarEquipo.getText();
            int categoria = cbAgregarEquipoCategoria.getSelectedIndex();
            int division = cbAgregarEquipoDivision.getSelectedIndex();
            ge.guardarEquipo(nombre, categoria, division);
            dispose();
        
    }//GEN-LAST:event_btnAgregarEquipoActionPerformed

    private void btnCancelarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEquipoActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarEquipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarEquipo dialog = new AgregarEquipo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEquipo;
    private javax.swing.JButton btnCancelarEquipo;
    private javax.swing.JComboBox<String> cbAgregarEquipoCategoria;
    private javax.swing.JComboBox<String> cbAgregarEquipoDivision;
    private javax.swing.JLabel lblAgreagarEquipo;
    private javax.swing.JLabel lblLogoAgregarEquipo;
    private javax.swing.JTextField txtAgregarEquipo;
    // End of variables declaration//GEN-END:variables
}
