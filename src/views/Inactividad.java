/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import connection.Conn;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sources.GestionarCampos;
import sources.GestionarEquipos;
import sources.MostrarDatos;
import sources.OCampos;


/**
 *
 * @author A644308
 */
public class Inactividad extends javax.swing.JFrame {
        private FondoVentana fondo;

        
        
public Inactividad() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);
        fondo = new FondoVentana();
        this.add(fondo);
            
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
   
        });
        
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                  int x, y;
                  x = Inactividad.this.getWidth();
                  y = Inactividad.this.getHeight();
                  fondo.fondoZize(x, y);
            }
        });  
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFestivos = new javax.swing.JPanel();
        lbFestivosFechaInicio = new javax.swing.JLabel();
        dFestivosFechaInicio = new com.toedter.calendar.JDateChooser();
        lblFestivosFechaFin = new javax.swing.JLabel();
        dFestivosFechaFin = new com.toedter.calendar.JDateChooser();
        lblFestivosDescripcion = new javax.swing.JLabel();
        cbFestivosDescripcion = new javax.swing.JComboBox<>();
        btnFestivosAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFestivos = new javax.swing.JTable();
        btnEliminarFestivos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de días festivos");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        pFestivos.setBackground(new java.awt.Color(255, 255, 255));
        pFestivos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 4, true), "  DÍAS FESTIVOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(31, 87, 12))); // NOI18N

        lbFestivosFechaInicio.setBackground(new java.awt.Color(255, 255, 255));
        lbFestivosFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFestivosFechaInicio.setText("Fecha de Incio");

        lblFestivosFechaFin.setBackground(new java.awt.Color(255, 255, 255));
        lblFestivosFechaFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFestivosFechaFin.setText("Fecha de Fin");

        lblFestivosDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblFestivosDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFestivosDescripcion.setText("Descripción");

        cbFestivosDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbFestivosDescripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un motivo", "Periodo hábil", "Fiesta nacional", "Fiesta local", "Periodo vacacional", "Otros" }));

        btnFestivosAceptar.setBackground(new java.awt.Color(31, 87, 12));
        btnFestivosAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnFestivosAceptar.setText("Aceptar");
        btnFestivosAceptar.setMaximumSize(new java.awt.Dimension(120, 23));
        btnFestivosAceptar.setMinimumSize(new java.awt.Dimension(120, 23));
        btnFestivosAceptar.setPreferredSize(new java.awt.Dimension(120, 23));
        btnFestivosAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFestivosAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFestivosLayout = new javax.swing.GroupLayout(pFestivos);
        pFestivos.setLayout(pFestivosLayout);
        pFestivosLayout.setHorizontalGroup(
            pFestivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFestivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFestivosFechaInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dFestivosFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFestivosFechaFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dFestivosFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFestivosDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFestivosDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
                .addComponent(btnFestivosAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFestivosLayout.setVerticalGroup(
            pFestivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFestivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pFestivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dFestivosFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dFestivosFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFestivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbFestivosDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbFestivosFechaInicio)
                        .addComponent(lblFestivosFechaFin)
                        .addComponent(lblFestivosDescripcion)
                        .addComponent(btnFestivosAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        tFestivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha de Inicio", "Fecha de Fin", "Descripción"
            }
        ));
        tFestivos.setEnabled(false);
        jScrollPane1.setViewportView(tFestivos);

        btnEliminarFestivos.setBackground(new java.awt.Color(31, 87, 12));
        btnEliminarFestivos.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarFestivos.setText("Eliminar día");
        btnEliminarFestivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFestivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pFestivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarFestivos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pFestivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarFestivos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckLunesPrimeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckLunesPrimeraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckLunesPrimeraActionPerformed

    private void btnFestivosAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFestivosAceptarActionPerformed
        if(dFestivosFechaInicio.getDate()==null){
            ImageIcon icon = new ImageIcon(getClass().getResource("/resources/resources/warning.png"));
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fecha de inicio","Seleccione una  fecha de inicio", JOptionPane.QUESTION_MESSAGE, icon);
        
        }if(dFestivosFechaFin.getDate()==null){
            ImageIcon icon = new ImageIcon(getClass().getResource("/resources/warning.png"));
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fecha de fin","Seleccione una  fecha de fin", JOptionPane.QUESTION_MESSAGE, icon);
        
        }if (cbFestivosDescripcion.getSelectedItem().toString().equals("Seleccione un motivo")){
            ImageIcon icon = new ImageIcon(getClass().getResource("/resources//warning.png"));
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un motivo","Seleccione un motivo", JOptionPane.QUESTION_MESSAGE, icon);
        
        }else{
              Date fechaInicio = this.dFestivosFechaInicio.getDate();
              Date fechaFin = this.dFestivosFechaFin.getDate();
              SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
 
        }   
    }//GEN-LAST:event_btnFestivosAceptarActionPerformed

    private void btnEliminarFestivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFestivosActionPerformed

    }//GEN-LAST:event_btnEliminarFestivosActionPerformed
   
    public void close() {
             dispose();             
    }
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
            java.util.logging.Logger.getLogger(Inactividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inactividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inactividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inactividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inactividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarFestivos;
    private javax.swing.JButton btnFestivosAceptar;
    private javax.swing.JComboBox<String> cbFestivosDescripcion;
    private com.toedter.calendar.JDateChooser dFestivosFechaFin;
    private com.toedter.calendar.JDateChooser dFestivosFechaInicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFestivosFechaInicio;
    private javax.swing.JLabel lblFestivosDescripcion;
    private javax.swing.JLabel lblFestivosFechaFin;
    private javax.swing.JPanel pFestivos;
    private javax.swing.JTable tFestivos;
    // End of variables declaration//GEN-END:variables
}
