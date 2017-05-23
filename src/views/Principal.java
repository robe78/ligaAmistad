/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import sources.LeerExcel;

/**
 *
 * @author rob_a
 */
public class Principal extends javax.swing.JFrame {

private FondoVentana fondo;
    /**
     * Creates new form Panel
     */
    public Principal() {
        
        initComponents();
    
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon("src\\resources\\logo1.png".toString());
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
        lblLogoPrincipal.setText(null);
        lblLogoPrincipal.setIcon( icono );
        
        Image iconMenu = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo1.png"));
        setIconImage(iconMenu);
        
        
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
                  x = Principal.this.getWidth();
                  y = Principal.this.getHeight();

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

        lblLogoPrincipal = new javax.swing.JLabel();
        btncalendarioP = new javax.swing.JButton();
        btnEquiposP = new javax.swing.JButton();
        btnCamposP = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        mbprincipal = new javax.swing.JMenuBar();
        mMenu = new javax.swing.JMenu();
        mOpciones = new javax.swing.JMenu();
        miImpExcel = new javax.swing.JMenuItem();
        mInsEquipo = new javax.swing.JMenuItem();
        mInsCampo = new javax.swing.JMenuItem();
        miCambiarLogo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mGenerarCalendario = new javax.swing.JMenuItem();
        mConfiguracion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liga de la Amistad");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        lblLogoPrincipal.setMaximumSize(new java.awt.Dimension(450, 450));
        lblLogoPrincipal.setMinimumSize(new java.awt.Dimension(450, 450));
        lblLogoPrincipal.setPreferredSize(new java.awt.Dimension(450, 450));

        btncalendarioP.setBackground(new java.awt.Color(31, 87, 12));
        btncalendarioP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 48)); // NOI18N
        btncalendarioP.setForeground(new java.awt.Color(255, 255, 255));
        btncalendarioP.setText("GENERAR CALENDARIO");
        btncalendarioP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncalendarioP.setFocusPainted(false);
        btncalendarioP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncalendarioPMouseEntered(evt);
            }
        });
        btncalendarioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalendarioPActionPerformed(evt);
            }
        });

        btnEquiposP.setBackground(new java.awt.Color(31, 87, 12));
        btnEquiposP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 48)); // NOI18N
        btnEquiposP.setForeground(new java.awt.Color(255, 255, 255));
        btnEquiposP.setText("CONFIGURACIÓN");
        btnEquiposP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposPActionPerformed(evt);
            }
        });

        btnCamposP.setBackground(new java.awt.Color(31, 87, 12));
        btnCamposP.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 48)); // NOI18N
        btnCamposP.setForeground(new java.awt.Color(255, 255, 255));
        btnCamposP.setText("POR DETERMINAR");
        btnCamposP.setActionCommand("");
        btnCamposP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamposPActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(31, 87, 12));
        btnSalir.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 48)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        mbprincipal.setBackground(new java.awt.Color(31, 87, 12));
        mbprincipal.setForeground(new java.awt.Color(255, 255, 255));

        mMenu.setForeground(new java.awt.Color(255, 255, 255));
        mMenu.setText("Menú");

        mOpciones.setBackground(new java.awt.Color(31, 87, 12));
        mOpciones.setText("Archivos");

        miImpExcel.setBackground(new java.awt.Color(31, 87, 12));
        miImpExcel.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miImpExcel.setForeground(new java.awt.Color(255, 255, 255));
        miImpExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/importar.png"))); // NOI18N
        miImpExcel.setText("Importar Excel");
        miImpExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miImpExcelActionPerformed(evt);
            }
        });
        mOpciones.add(miImpExcel);

        mInsEquipo.setBackground(new java.awt.Color(31, 87, 12));
        mInsEquipo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mInsEquipo.setForeground(new java.awt.Color(255, 255, 255));
        mInsEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/equipos_menu.png"))); // NOI18N
        mInsEquipo.setText("Insertar Equipo");
        mOpciones.add(mInsEquipo);

        mInsCampo.setBackground(new java.awt.Color(31, 87, 12));
        mInsCampo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mInsCampo.setForeground(new java.awt.Color(255, 255, 255));
        mInsCampo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/campo_menu.png"))); // NOI18N
        mInsCampo.setText("Insertar Campo");
        mInsCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInsCampoActionPerformed(evt);
            }
        });
        mOpciones.add(mInsCampo);

        miCambiarLogo.setBackground(new java.awt.Color(31, 87, 12));
        miCambiarLogo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miCambiarLogo.setForeground(new java.awt.Color(255, 255, 255));
        miCambiarLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cambiarlogo.png"))); // NOI18N
        miCambiarLogo.setText("cambiar Logo");
        miCambiarLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCambiarLogoActionPerformed(evt);
            }
        });
        mOpciones.add(miCambiarLogo);

        mMenu.add(mOpciones);

        jMenu2.setBackground(new java.awt.Color(31, 87, 12));
        jMenu2.setText("Opciones");

        mGenerarCalendario.setBackground(new java.awt.Color(31, 87, 12));
        mGenerarCalendario.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mGenerarCalendario.setForeground(new java.awt.Color(255, 255, 255));
        mGenerarCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/generar.png"))); // NOI18N
        mGenerarCalendario.setText("Generar Calendario");
        mGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGenerarCalendarioActionPerformed(evt);
            }
        });
        jMenu2.add(mGenerarCalendario);

        mConfiguracion.setBackground(new java.awt.Color(31, 87, 12));
        mConfiguracion.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        mConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/configuracion.png"))); // NOI18N
        mConfiguracion.setText("Configuración");
        mConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfiguracionActionPerformed(evt);
            }
        });
        jMenu2.add(mConfiguracion);

        mMenu.add(jMenu2);

        mbprincipal.add(mMenu);

        setJMenuBar(mbprincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCamposP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquiposP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncalendarioP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btncalendarioP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEquiposP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCamposP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEquiposPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposPActionPerformed
        Restricciones frm = new Restricciones ();
        frm.setVisible(true);
    }//GEN-LAST:event_btnEquiposPActionPerformed

    private void btncalendarioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalendarioPActionPerformed
        Calendario frm = new Calendario ();
        frm.setVisible(true);
    }//GEN-LAST:event_btncalendarioPActionPerformed

    private void btnCamposPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamposPActionPerformed

    }//GEN-LAST:event_btnCamposPActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            close();                   
    }//GEN-LAST:event_btnSalirActionPerformed

    private void miImpExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miImpExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Excel (*.xls; *.xlsx)", "xls", "xlsx");
        fileChooser.setFileFilter(filtro);
        int seleccion = fileChooser.showOpenDialog(new Principal());
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            File fichero = fileChooser.getSelectedFile();
            //Desktop.getDesktop().open(fichero);
            //aqui debe coger los datos del excel y cargarlos a la BBDD
            new Thread(new LeerExcel(fichero)).start();

        }
    }//GEN-LAST:event_miImpExcelActionPerformed

    private void miCambiarLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCambiarLogoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        fileChooser.setFileFilter(filtro);
        int seleccion = fileChooser.showOpenDialog(new Principal());
        if (seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            File destino = new File ("src\\resources\\logo1.png");
            try{

                if(!destino.exists()) {
                    destino.createNewFile();
                }
                FileChannel entrada = null;
                FileChannel salida = null;
                try {
                    entrada = new FileInputStream(fichero).getChannel();
                    salida = new FileOutputStream(destino).getChannel();
                    salida.transferFrom(entrada,0, entrada.size());
                    ImageIcon icon = new ImageIcon(destino.toString());
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
                    lblLogoPrincipal.setText(null);
                    lblLogoPrincipal.setIcon( icono );
                    Image iconMenu = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo1.png"));
                    setIconImage(iconMenu);
                }
                finally {
                    if(entrada != null) {
                        entrada.close();
                    }
                    if(salida != null) {
                        salida.close();
                    }
                }
            }catch(
                Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        }
    }//GEN-LAST:event_miCambiarLogoActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void btncalendarioPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncalendarioPMouseEntered

    }//GEN-LAST:event_btncalendarioPMouseEntered

    private void mGenerarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGenerarCalendarioActionPerformed
        Calendario frm = new Calendario ();
        frm.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_mGenerarCalendarioActionPerformed

    private void mConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfiguracionActionPerformed
        Restricciones frm = new Restricciones ();
        frm.setVisible(true);
    }//GEN-LAST:event_mConfiguracionActionPerformed

    private void mInsCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInsCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mInsCampoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    public void close() {
        ImageIcon icon = new ImageIcon("src/resources/exit.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (input == JOptionPane.YES_OPTION) {
             System.exit(0);             
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamposP;
    private javax.swing.JButton btnEquiposP;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btncalendarioP;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JLabel lblLogoPrincipal;
    private javax.swing.JMenuItem mConfiguracion;
    private javax.swing.JMenuItem mGenerarCalendario;
    private javax.swing.JMenuItem mInsCampo;
    private javax.swing.JMenuItem mInsEquipo;
    private javax.swing.JMenu mMenu;
    private javax.swing.JMenu mOpciones;
    private javax.swing.JMenuBar mbprincipal;
    private javax.swing.JMenuItem miCambiarLogo;
    private javax.swing.JMenuItem miImpExcel;
    // End of variables declaration//GEN-END:variables
}
