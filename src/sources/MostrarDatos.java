package sources;

import connection.Conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import views.Restricciones;

/**
 *
 * @author santy
 */
public class MostrarDatos {
    private final Conn con = new Conn();
        
    public void llenarComboCategorias(JComboBox cbCategoria){
        con.conectar();
        ResultSet categoria = con.getValues("COMPETICION", "Competicion", "", "ID");
            try {
                while(categoria.next()){
                    cbCategoria.addItem(categoria.getString("COMPETICION"));
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
  
            con.desconectar();
    }
    
    public void llenarComboDivisiones(JComboBox cbDivision){
        con.conectar();
        ResultSet division = con.getValues("DIVISION", "Division", "", "ID");
            try {
                while(division.next()){
                    cbDivision.addItem(division.getString("DIVISION"));
                    
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
    
    public void llenarComboJornadas(JComboBox cbJornadas){
        con.conectar();
        ResultSet jornada = con.getValues("DISTINCT JORNADA", "Campeonato", "", "JORNADA");
            try {
                while(jornada.next()){
                    cbJornadas.addItem(jornada.getInt("JORNADA"));
                    
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
    
    public void llenarComboEquipos(JComboBox cbEquipos){
        con.conectar();
        ResultSet equipos = con.getValues("NOMBRE", "Equipos", "", "ID");
            try {
                while(equipos.next()){
                    cbEquipos.addItem(equipos.getString("NOMBRE"));
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
       
    public void llenarComboNoCoincidir(JComboBox cbNoCoincidir, int id){
        cbNoCoincidir.removeAllItems();
        try {
            cbNoCoincidir.addItem("");
            int idCat = 0;
            con.conectar();
            ResultSet idCategoria = con.getValues("ID_COMPETICION", "Equipos", "ID = " + id, "");
            while(idCategoria.next()){
                idCat = idCategoria.getInt("ID_COMPETICION");
            }
            ResultSet noCoincidir = con.getValues("NOMBRE", "Equipos", "ID_COMPETICION != " + idCat, "ID");
            while(noCoincidir.next()){
                cbNoCoincidir.addItem(noCoincidir.getString("NOMBRE"));
            }
            con.desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(MostrarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarComboCampos(JComboBox cbCampos){
        con.conectar();
        ResultSet campos = con.getValues("CAMPO", "Campos", "", "ID");
            try {
                while(campos.next()){
                    cbCampos.addItem(campos.getString("CAMPO"));
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
    
    public void llenarTCalendario(JTable tCalendario){
        DefaultTableModel model = (DefaultTableModel) tCalendario.getModel();
        Object[] fila = new Object[10];
        con.conectar();
        String select = "c.ID, c.JORNADA, c.FECHA, c.HORA, l.NOMBRE AS \"LOCAL\", "
                + "v.NOMBRE AS \"VISITANTE\", ca.CAMPO, c.APLAZADO, com.COMPETICION AS \"CATEGORIA\", "
                + "d.DIVISION AS \"DIVISION\"";
        String from = " Campeonato c INNER JOIN Equipos l ON c.ID_LOCAL = l.ID "
                + "INNER JOIN Equipos v ON c.ID_VISITANTE = v.ID "
                + "LEFT JOIN Campos ca ON c.ID_CAMPO = ca.ID INNER JOIN Competicion com ON l.ID_COMPETICION = com.ID "
                + "INNER JOIN Division d ON l.ID_DIVISION = d.ID";
        String order = "c.JORNADA, com.ID, d.ID"; 
        ResultSet campeonato = con.getValues(select, from, "", order);
            try {
                while(campeonato.next()){
                    fila[0] = campeonato.getInt("ID");
                    fila[1] = campeonato.getInt("JORNADA");
                    fila[2] = campeonato.getDate("FECHA");
                    if(campeonato.getDate("FECHA") != null){
                        fila[3] = calculaDia((Date)campeonato.getDate("FECHA"));
                    }else{
                        fila[3] = "";
                    }
                    fila[4] = campeonato.getString("HORA");
                    fila[5] = campeonato.getString("LOCAL");
                    fila[6] = campeonato.getString("VISITANTE");
                    fila[7] = campeonato.getString("CAMPO");
                    if(campeonato.getString("DIVISION").equalsIgnoreCase("sin división")){
                        fila[8] = campeonato.getString("CATEGORIA");
                    }else{
                        fila[8] = campeonato.getString("CATEGORIA")+" - "+campeonato.getString("DIVISION");
                    }
                    if(campeonato.getInt("APLAZADO") == 1){
                        fila[9] = true;
                    }else{
                        fila[9] = null;
                    }
                    model.addRow(fila);
                    
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
        tCalendario.setModel(model);
    }
    
    public void llenarTAplazados(JTable tAplazados){
        DefaultTableModel model = (DefaultTableModel) tAplazados.getModel();
        Object[] fila = new Object[10];
        con.conectar();
        String select = "c.ID, c.JORNADA, c.FECHA, c.HORA, l.NOMBRE AS \"LOCAL\", "
                + "v.NOMBRE AS \"VISITANTE\", ca.CAMPO, c.APLAZADO, com.COMPETICION AS \"CATEGORIA\", "
                + "d.DIVISION AS \"DIVISION\"";
        String from = " Campeonato c INNER JOIN Equipos l ON c.ID_LOCAL = l.ID "
                + "INNER JOIN Equipos v ON c.ID_VISITANTE = v.ID "
                + "LEFT JOIN Campos ca ON c.ID_CAMPO = ca.ID INNER JOIN Competicion com ON l.ID_COMPETICION = com.ID "
                + "INNER JOIN Division d ON l.ID_DIVISION = d.ID";
        String order = "c.JORNADA, com.ID, d.ID"; 
        ResultSet campeonato = con.getValues(select, from, "APLAZADO = 1", order);
            try {
                while(campeonato.next()){
                    fila[0] = campeonato.getInt("ID");
                    fila[1] = campeonato.getInt("JORNADA");
                    fila[2] = campeonato.getDate("FECHA");
                    if(campeonato.getDate("FECHA") != null){
                        fila[3] = calculaDia((Date)campeonato.getDate("FECHA"));
                    }else{
                        fila[3] = "";
                    }
                    fila[4] = campeonato.getString("HORA");
                    fila[5] = campeonato.getString("LOCAL");
                    fila[6] = campeonato.getString("VISITANTE");
                    fila[7] = campeonato.getString("CAMPO");
                    if(campeonato.getString("DIVISION").equalsIgnoreCase("sin división")){
                        fila[8] = campeonato.getString("CATEGORIA");
                    }else{
                        fila[8] = campeonato.getString("CATEGORIA")+" - "+campeonato.getString("DIVISION");
                    }
                    if(campeonato.getInt("APLAZADO") == 1){
                        fila[9] = true;
                    }else{
                        fila[9] = null;
                    }
                    model.addRow(fila);
                    
                } 
            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
        tAplazados.setModel(model);
    }
    
    public void llenarComboAgregarEquiposCategoria(JComboBox cbAgregarEquipoCategoria, String equipo) {
        con.conectar();
        String select ="c.COMPETICION";
        String from ="competicion c INNER JOIN equipos e ON c.ID = e.ID_COMPETICION";
        String where ="e.NOMBRE = '"+equipo+"'" ;
        ResultSet equipos = con.getValues(select, from, where , "");        

            try {
                while(equipos.next()){
                cbAgregarEquipoCategoria.setSelectedItem(equipos.getString("COMPETICION"));
                }

            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
    
    public void llenarComboAgregarEquiposDivision (JComboBox cbAgregarEquipoDivision, String equipo) {
        con.conectar();
        String select ="d.DIVISION";
        String from ="division d INNER JOIN equipos e on d.ID = e.ID_DIVISION";
        String where ="e.NOMBRE = '"+equipo+"'" ;
        ResultSet equipos = con.getValues(select, from, where , "");        

            try {
                while(equipos.next()){
                cbAgregarEquipoDivision.setSelectedItem(equipos.getString("DIVISION"));
                }

            }catch (SQLException ex) {
                Logger.getLogger(Restricciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        con.desconectar();
    }
    
    private String calculaDia(Date fecha){
        String dia = "";
        Calendar d = Calendar.getInstance();
        String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miércoles",
        			    "Jueves", "Viernes", "Sábado"};
        
        d.setTime(fecha);
        dia = strDays[d.get(Calendar.DAY_OF_WEEK)-1];
        return dia;
    }
}
