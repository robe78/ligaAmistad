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
import javafx.stage.FileChooser;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import sources.GestionarCampos;
import sources.LeerExcel;

/**
 *
 * @author rob_a
 */
public class Principal extends javax.swing.JFrame {

private FondoPrincipal fondo;
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
        
        
        fondo = new FondoPrincipal();
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
        mArchivo = new javax.swing.JMenu();
        miNuevaJornada = new javax.swing.JMenuItem();
        miCambiarLogo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSalir = new javax.swing.JMenuItem();
        mGestion = new javax.swing.JMenu();
        mImportarPrincipal = new javax.swing.JMenu();
        miImportarCampos = new javax.swing.JMenuItem();
        miImportarEquipos = new javax.swing.JMenuItem();
        mAgregarPrincipal = new javax.swing.JMenu();
        miAgregarCampos = new javax.swing.JMenuItem();
        miAgregarCompeticion = new javax.swing.JMenuItem();
        miAgregarDivision = new javax.swing.JMenuItem();
        miAgregarEquipos = new javax.swing.JMenuItem();
        mBBDD = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        miVaciarCalendario = new javax.swing.JMenuItem();
        miVaciarCampos = new javax.swing.JMenuItem();
        miVaciarCompeticion = new javax.swing.JMenuItem();
        mivaciarDivision = new javax.swing.JMenuItem();
        mivaciarEquipos = new javax.swing.JMenuItem();

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
        btncalendarioP.setText("GESTIONAR CALENDARIO");
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

        mArchivo.setForeground(new java.awt.Color(255, 255, 255));
        mArchivo.setText("Archivo");

        miNuevaJornada.setBackground(new java.awt.Color(31, 87, 12));
        miNuevaJornada.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miNuevaJornada.setForeground(new java.awt.Color(255, 255, 255));
        miNuevaJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new.png"))); // NOI18N
        miNuevaJornada.setText(" Nueva Temporada");
        mArchivo.add(miNuevaJornada);

        miCambiarLogo.setBackground(new java.awt.Color(31, 87, 12));
        miCambiarLogo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miCambiarLogo.setForeground(new java.awt.Color(255, 255, 255));
        miCambiarLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cambiarlogo.png"))); // NOI18N
        miCambiarLogo.setText(" Cambiar Logo");
        miCambiarLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCambiarLogoActionPerformed(evt);
            }
        });
        mArchivo.add(miCambiarLogo);

        jMenuItem1.setBackground(new java.awt.Color(31, 87, 12));
        jMenuItem1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        jMenuItem1.setText(" Acerca...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mArchivo.add(jMenuItem1);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        mArchivo.add(jSeparator1);

        miSalir.setBackground(new java.awt.Color(31, 87, 12));
        miSalir.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miSalir.setForeground(new java.awt.Color(255, 255, 255));
        miSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/salir2.png"))); // NOI18N
        miSalir.setText(" Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mArchivo.add(miSalir);

        mbprincipal.add(mArchivo);

        mGestion.setBackground(new java.awt.Color(31, 87, 12));
        mGestion.setForeground(new java.awt.Color(255, 255, 255));
        mGestion.setText("Gestión");

        mImportarPrincipal.setBackground(new java.awt.Color(31, 87, 12));
        mImportarPrincipal.setForeground(new java.awt.Color(31, 87, 12));
        mImportarPrincipal.setText("Importar");

        miImportarCampos.setBackground(new java.awt.Color(31, 87, 12));
        miImportarCampos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miImportarCampos.setForeground(new java.awt.Color(255, 255, 255));
        miImportarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/campo_menu.png"))); // NOI18N
        miImportarCampos.setText(" Campos");
        miImportarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miImportarCamposActionPerformed(evt);
            }
        });
        mImportarPrincipal.add(miImportarCampos);

        miImportarEquipos.setBackground(new java.awt.Color(31, 87, 12));
        miImportarEquipos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miImportarEquipos.setForeground(new java.awt.Color(255, 255, 255));
        miImportarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/equipos_menu.png"))); // NOI18N
        miImportarEquipos.setText(" Equipos");
        miImportarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miImportarEquiposActionPerformed(evt);
            }
        });
        mImportarPrincipal.add(miImportarEquipos);

        mGestion.add(mImportarPrincipal);

        mAgregarPrincipal.setBackground(new java.awt.Color(31, 87, 12));
        mAgregarPrincipal.setForeground(new java.awt.Color(31, 87, 12));
        mAgregarPrincipal.setText("Agregar");

        miAgregarCampos.setBackground(new java.awt.Color(31, 87, 12));
        miAgregarCampos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miAgregarCampos.setForeground(new java.awt.Color(255, 255, 255));
        miAgregarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/campo_menu.png"))); // NOI18N
        miAgregarCampos.setText(" Campo");
        miAgregarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgregarCamposActionPerformed(evt);
            }
        });
        mAgregarPrincipal.add(miAgregarCampos);

        miAgregarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        miAgregarCompeticion.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miAgregarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        miAgregarCompeticion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/competicion.png"))); // NOI18N
        miAgregarCompeticion.setText(" Competición");
        miAgregarCompeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgregarCompeticionActionPerformed(evt);
            }
        });
        mAgregarPrincipal.add(miAgregarCompeticion);

        miAgregarDivision.setBackground(new java.awt.Color(31, 87, 12));
        miAgregarDivision.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miAgregarDivision.setForeground(new java.awt.Color(255, 255, 255));
        miAgregarDivision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/division.png"))); // NOI18N
        miAgregarDivision.setText(" División");
        miAgregarDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgregarDivisionActionPerformed(evt);
            }
        });
        mAgregarPrincipal.add(miAgregarDivision);

        miAgregarEquipos.setBackground(new java.awt.Color(31, 87, 12));
        miAgregarEquipos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miAgregarEquipos.setForeground(new java.awt.Color(255, 255, 255));
        miAgregarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/equipos_menu.png"))); // NOI18N
        miAgregarEquipos.setText(" Equipo");
        miAgregarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgregarEquiposActionPerformed(evt);
            }
        });
        mAgregarPrincipal.add(miAgregarEquipos);

        mGestion.add(mAgregarPrincipal);

        mbprincipal.add(mGestion);

        mBBDD.setBackground(new java.awt.Color(31, 87, 12));
        mBBDD.setForeground(new java.awt.Color(255, 255, 255));
        mBBDD.setText("BBDD");

        jMenu1.setForeground(new java.awt.Color(31, 87, 12));
        jMenu1.setText("Vaciar");

        miVaciarCalendario.setBackground(new java.awt.Color(31, 87, 12));
        miVaciarCalendario.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miVaciarCalendario.setForeground(new java.awt.Color(255, 255, 255));
        miVaciarCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/calendario.png"))); // NOI18N
        miVaciarCalendario.setText(" Calendario");
        miVaciarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVaciarCalendarioActionPerformed(evt);
            }
        });
        jMenu1.add(miVaciarCalendario);

        miVaciarCampos.setBackground(new java.awt.Color(31, 87, 12));
        miVaciarCampos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miVaciarCampos.setForeground(new java.awt.Color(255, 255, 255));
        miVaciarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/campo_menu.png"))); // NOI18N
        miVaciarCampos.setText(" Campos");
        miVaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVaciarCamposActionPerformed(evt);
            }
        });
        jMenu1.add(miVaciarCampos);

        miVaciarCompeticion.setBackground(new java.awt.Color(31, 87, 12));
        miVaciarCompeticion.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        miVaciarCompeticion.setForeground(new java.awt.Color(255, 255, 255));
        miVaciarCompeticion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/competicion.png"))); // NOI18N
        miVaciarCompeticion.setText(" Competición");
        miVaciarCompeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVaciarCompeticionActionPerformed(evt);
            }
        });
        jMenu1.add(miVaciarCompeticion);

        mivaciarDivision.setBackground(new java.awt.Color(31, 87, 12));
        mivaciarDivision.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mivaciarDivision.setForeground(new java.awt.Color(255, 255, 255));
        mivaciarDivision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/division.png"))); // NOI18N
        mivaciarDivision.setText(" División");
        mivaciarDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mivaciarDivisionActionPerformed(evt);
            }
        });
        jMenu1.add(mivaciarDivision);

        mivaciarEquipos.setBackground(new java.awt.Color(31, 87, 12));
        mivaciarEquipos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        mivaciarEquipos.setForeground(new java.awt.Color(255, 255, 255));
        mivaciarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/equipos_menu.png"))); // NOI18N
        mivaciarEquipos.setText(" Equipos");
        mivaciarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mivaciarEquiposActionPerformed(evt);
            }
        });
        jMenu1.add(mivaciarEquipos);

        mBBDD.add(jMenu1);

        mbprincipal.add(mBBDD);

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

    private void miImportarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miImportarCamposActionPerformed
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
    }//GEN-LAST:event_miImportarCamposActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        close(); 
    }//GEN-LAST:event_miSalirActionPerformed

    private void miAgregarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgregarCamposActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/campo_menu.png");
        Object campo = JOptionPane.showInputDialog(null, "Nombre del campo", "Agregar campo", JOptionPane.QUESTION_MESSAGE,icon,null,""); 
        if(campo != null){
            String scampo= campo.toString();
            GestionarCampos gc = new GestionarCampos();
            gc.guardarCampo(scampo);            
        }
        
//        String campo = JOptionPane.showInputDialog(null, "Nombre del campo", "Agregar campo", JOptionPane.QUESTION_MESSAGE);
//        if(campo != null){
//            GestionarCampos gc = new GestionarCampos();
//            gc.guardarCampo(campo);
//        }
    }//GEN-LAST:event_miAgregarCamposActionPerformed

    private void miVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVaciarCamposActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/warning.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todos los campos de la BBDD ?", "Eliminar campos", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (input == JOptionPane.YES_OPTION) {
              
        }  
    }//GEN-LAST:event_miVaciarCamposActionPerformed

    private void miImportarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miImportarEquiposActionPerformed
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
    }//GEN-LAST:event_miImportarEquiposActionPerformed

    private void miAgregarCompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgregarCompeticionActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/competicion.png");
        Object competicion = JOptionPane.showInputDialog(null, "Nombre de la competición", "Agregar competición", JOptionPane.QUESTION_MESSAGE,icon,null,"");
        if(competicion != null){
            String scompeticion = competicion.toString();
        }
    }//GEN-LAST:event_miAgregarCompeticionActionPerformed

    private void miAgregarDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgregarDivisionActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/division.png");
        Object division = JOptionPane.showInputDialog(null, "Nombre de la división", "Agregar división", JOptionPane.QUESTION_MESSAGE,icon,null,"");    
        if(division != null){
            String sdivision = division.toString();    
        }
    }//GEN-LAST:event_miAgregarDivisionActionPerformed

    private void miAgregarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgregarEquiposActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/equipos_menu.png");
        Object equipo = JOptionPane.showInputDialog(null, "Nombre del equipo", "Agregar equipo", JOptionPane.QUESTION_MESSAGE,icon,null,"");
        if(equipo != null){
           String sequipo = equipo.toString();
        }
    }//GEN-LAST:event_miAgregarEquiposActionPerformed

    private void miVaciarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVaciarCalendarioActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/warning.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el calendario de la BBDD ?", "Eliminar calendario", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (input == JOptionPane.YES_OPTION) {
              
        }  
    }//GEN-LAST:event_miVaciarCalendarioActionPerformed

    private void miVaciarCompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVaciarCompeticionActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/warning.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todas las competiciones de la BBDD ?", "Eliminar competiciones", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (input == JOptionPane.YES_OPTION) {
              
        }  
    }//GEN-LAST:event_miVaciarCompeticionActionPerformed

    private void mivaciarDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mivaciarDivisionActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/warning.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todas las divisiones de la BBDD ?", "Eliminar divisiones", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (input == JOptionPane.YES_OPTION) {
              
        }  
    }//GEN-LAST:event_mivaciarDivisionActionPerformed

    private void mivaciarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mivaciarEquiposActionPerformed
        ImageIcon icon = new ImageIcon("src/resources/warning.png");
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todos los equipos de la BBDD ?", "Eliminar equipos", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (input == JOptionPane.YES_OPTION) {
              
        }  
    }//GEN-LAST:event_mivaciarEquiposActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Acerca(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblLogoPrincipal;
    private javax.swing.JMenu mAgregarPrincipal;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mBBDD;
    private javax.swing.JMenu mGestion;
    private javax.swing.JMenu mImportarPrincipal;
    private javax.swing.JMenuBar mbprincipal;
    private javax.swing.JMenuItem miAgregarCampos;
    private javax.swing.JMenuItem miAgregarCompeticion;
    private javax.swing.JMenuItem miAgregarDivision;
    private javax.swing.JMenuItem miAgregarEquipos;
    private javax.swing.JMenuItem miCambiarLogo;
    private javax.swing.JMenuItem miImportarCampos;
    private javax.swing.JMenuItem miImportarEquipos;
    private javax.swing.JMenuItem miNuevaJornada;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem miVaciarCalendario;
    private javax.swing.JMenuItem miVaciarCampos;
    private javax.swing.JMenuItem miVaciarCompeticion;
    private javax.swing.JMenuItem mivaciarDivision;
    private javax.swing.JMenuItem mivaciarEquipos;
    // End of variables declaration//GEN-END:variables
}
