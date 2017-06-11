/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;

/**
 *
 * @author rob_a
 */
public class EditarCompeticion extends javax.swing.JDialog {

    /**
     * Creates new form EditarCampo
     */
    public EditarCompeticion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(232, 245, 228));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditarCompeticion = new javax.swing.JLabel();
        cbEditarCompeticion = new javax.swing.JComboBox<>();
        btnEditarCompeticion = new javax.swing.JButton();
        btnEliminarCompeticion = new javax.swing.JButton();
        btnCancelarCompeticion = new javax.swing.JButton();
        lbllogoEditarCompeticion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar competición");
        setBackground(new java.awt.Color(31, 87, 12));

        lblEditarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        lblEditarCompeticion.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        lblEditarCompeticion.setForeground(new java.awt.Color(31, 87, 12));
        lblEditarCompeticion.setText("Seleccione una competición");

        cbEditarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        cbEditarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        cbEditarCompeticion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEditarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        btnEditarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCompeticion.setText("Editar");
        btnEditarCompeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCompeticionActionPerformed(evt);
            }
        });

        btnEliminarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        btnEliminarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCompeticion.setText("Eliminar");
        btnEliminarCompeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompeticionActionPerformed(evt);
            }
        });

        btnCancelarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        btnCancelarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCompeticion.setText("Cancelar");
        btnCancelarCompeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompeticionActionPerformed(evt);
            }
        });

        lbllogoEditarCompeticion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/competicion.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbEditarCompeticion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbllogoEditarCompeticion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditarCompeticion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditarCompeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCompeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCompeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbllogoEditarCompeticion)
                    .addComponent(lblEditarCompeticion))
                .addGap(18, 18, 18)
                .addComponent(cbEditarCompeticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCompeticion)
                    .addComponent(btnEliminarCompeticion)
                    .addComponent(btnEditarCompeticion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarCompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCompeticionActionPerformed
        cbEditarCompeticion.setEditable(true);
    }//GEN-LAST:event_btnEditarCompeticionActionPerformed

    private void btnEliminarCompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompeticionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarCompeticionActionPerformed

    private void btnCancelarCompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompeticionActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarCompeticionActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCompeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCompeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCompeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCompeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarCompeticion dialog = new EditarCompeticion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelarCompeticion;
    private javax.swing.JButton btnEditarCompeticion;
    private javax.swing.JButton btnEliminarCompeticion;
    private javax.swing.JComboBox<String> cbEditarCompeticion;
    private javax.swing.JLabel lblEditarCompeticion;
    private javax.swing.JLabel lbllogoEditarCompeticion;
    // End of variables declaration//GEN-END:variables
}
