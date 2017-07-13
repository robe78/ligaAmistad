package sources;

import connection.Conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santy
 */
public class GeneraCalendario {

    public GeneraCalendario() {
        this.idcampos = new ArrayList();
    }
    /*class oCampeonato{
        int id;
        int jornada;
        String fecha;
        String hora;
        int local;
        int visitante;
        int campo;
        boolean jugado;
        public oCampeonato(Object[] datos){
            this.id = (int) datos[0];
            this.jornada = (int) datos[1];
            this.fecha = (String) datos[2];
            this.hora = (String) datos[3];
            this.local = (int) datos[4];
            this.visitante = (int) datos[5];
            this.campo = (int)datos[6];
            this.jugado = (boolean) datos[7];
        }
    }
    
    class oRestricciones{
        int id;
        int id_equipo;
        int id_dia;
        int hora;
        int id_campo;
        int id_coindice;
        public oRestricciones(Object[] datos){
            this.id = (int)datos[0];
            this.id_equipo = (int)datos[1];
            this.id_dia = (int)datos[2];
            this.hora = (int)datos[3];
            this.id_campo = (int)datos[4];
            this.id_coindice = (int)datos[5];
        }
    }*/
       
    private final String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miércoles",
        			    "Jueves", "Viernes", "Sábado"};
    private int camposDisponibles;
    private int totalHorariosDisponibles;
    private int partidosPorJornada = 0;
    private int totalPartidosMostrados;
    private int jornada;
    private DefaultTableModel model;
    //private ResultSet campeonato;
    //private ResultSet restricciones;
    private ResultSet camposDis;
    private final ArrayList idcampos;
    //private ArrayList<oCampeonato> arrCampeonato;
    //private ArrayList<oRestricciones> arrRestricciones;
  
    public void generaFechas(String fInicio, String fFin, JTable tabla, JComboBox jornada){
        Conn conn = new Conn();
        model = (DefaultTableModel) tabla.getModel();
        this.jornada = (int) jornada.getSelectedItem();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        String dateInString = fInicio;
        String dateFinString = fFin; 
        
        conn.conectar();
        totalHorariosDisponibles = conn.totalRegistros("campos INNER JOIN cam_horarios ON ID = ID_CAMPO", "CONGELADO = 0");
        //campeonato = conn.getValues("*", "campeonato", "", "JORNADA");
        //restricciones = conn.getValues("*", "restricciones", "", "");
        camposDis = conn.getValues("*", "campos c INNER JOIN cam_horarios ch ON c.ID = ch.ID_CAMPO INNER JOIN hora h ON ch.ID_HORA = h.ID", "CONGELADO = 0", "c.ID");
        
        /*try{
            Object[] fCampeonato = new Object[8];
            arrCampeonato = new ArrayList();
            while(campeonato.next()){
                fCampeonato[0] = campeonato.getInt("ID");
                fCampeonato[1] = campeonato.getInt("JORNADA");
                fCampeonato[2] = campeonato.getDate("FECHA");
                fCampeonato[3] = campeonato.getTime("HORA");
                fCampeonato[4] = campeonato.getInt("ID_LOCAL");
                fCampeonato[5] = campeonato.getInt("ID_VISITANTE");
                fCampeonato[6] = campeonato.getInt("ID_CAMPO");
                fCampeonato[7] = campeonato.getBoolean("JUGADO");
                
                arrCampeonato.add(new oCampeonato(fCampeonato));
            }
            Object[] fRestricciones = new Object[6];
            arrRestricciones = new ArrayList();
            while(restricciones.next()){
                fRestricciones[0] = restricciones.getInt("ID");
                fRestricciones[1] = restricciones.getInt("ID_EQUIPO");
                fRestricciones[2] = restricciones.getInt("ID_DIA");
                fRestricciones[3] = restricciones.getInt("HORA");
                fRestricciones[4] = restricciones.getInt("ID_CAMPO");
                fRestricciones[5] = restricciones.getInt("ID_COINCIDE");
                
                arrRestricciones.add(new oRestricciones(fRestricciones));
            }
            
        }   catch (SQLException ex) {
            Logger.getLogger(GeneraCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        /** Reparto de campos **/
        totalPartidosMostrados = model.getRowCount();
        partidosPorJornada = 0;
        camposDisponibles = 0;
        for(int pa = 0; pa < totalPartidosMostrados; pa++){
            if(this.jornada == (int)model.getValueAt(pa, 1)){
                partidosPorJornada++;
            }
        }
        boolean jornadaCorrecta = false;
        boolean restriccion;
        int row;
        int cont = 0;
        Date dateIni = null;
        Date dateFin = null;
        try {
            dateIni = formatter.parse(dateInString);
            dateFin = formatter.parse(dateFinString);
        } catch (ParseException ex) {
            Logger.getLogger(GeneraCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar setDay = Calendar.getInstance();
        int dias=(int) ((dateFin.getTime()- dateIni.getTime())/86400000) + 1;
        setDay.setTime(dateIni);
System.out.println("Mostrados " +totalPartidosMostrados);
        bucle:
        for(int d = 0; d < totalPartidosMostrados; d++){
            if(this.jornada == (int)model.getValueAt(d, 1)){
                //jornadaCorrecta = true;
                if(totalHorariosDisponibles >= partidosPorJornada){
                    try{
                        camposDis.next();
                        restriccion = verificaRestriccionesCampos(d, tabla, this.jornada, (String)tabla.getValueAt(d, 5), camposDis.getInt("ID"));
                        row = camposDis.getRow();
                        while(restriccion){
System.out.println("d = " + d + " El equipo " + tabla.getValueAt(d, 5) + " No puede jugar en el campo " + camposDis.getString("CAMPO"));
                            camposDis.next();
                            restriccion = verificaRestriccionesCampos(d, tabla, this.jornada, (String)tabla.getValueAt(d, 5), camposDis.getInt("ID"));
System.out.println(camposDis.getRow());
                            if(camposDis.isLast()){
                                camposDis.first();
                                cont++;
                                if (cont >=1){
                                    continue bucle;
                                }
                            }
                        }
                        if(!restriccion){
                            tabla.setValueAt(camposDis.getString("CAMPO"), d, 7);
                            idcampos.add(camposDis.getInt("ID_CAMPO"));
                            tabla.setValueAt(getDia(camposDis.getInt("ID_DIA")), d, 3);
                            tabla.setValueAt(camposDis.getString("HORA"), d, 4);
                            String dayOfWeek = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
                            pintarFecha(d, dayOfWeek, dateIni, tabla);
                            for(int a = 1; a < dias-1; a++){
                                setDay.add(Calendar.DAY_OF_YEAR, 1);
                                String newDay = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
                                pintarFecha(d, newDay, setDay.getTime(), tabla);
                            }
                            camposDis.first();
                        }
                    }catch(SQLException ex){
//System.err.println(ex.getCause());
                    }
                }else{
                    //jornadaCorrecta = false;
                    ImageIcon icon = new ImageIcon(getClass().getResource("/resources/warning.png"));
                    JOptionPane.showMessageDialog(null, "NO hay suficientes horarios para los partidos mostrados", "Insuficientes horarios", JOptionPane.QUESTION_MESSAGE, icon);
                    break;
                }
            }
            System.out.println("d = " + d);
            System.out.println("Jornada = " + this.jornada);
            System.out.println("Tabla = " + (int)model.getValueAt(d, 1));
        }
        conn.desconectar();
        /** Fin reparto de campos **/
        
        /** Generación de fechas según campo asignado **/
        /*if(jornadaCorrecta){
            Date dateIni = formatter.parse(dateInString);
            Date dateFin = formatter.parse(dateFinString);
            Calendar setDay = Calendar.getInstance();
            int dias=(int) ((dateFin.getTime()- dateIni.getTime())/86400000) + 1;
            
            
            setDay.setTime(dateIni);
            String dayOfWeek = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
            pintarFecha(0, dayOfWeek, dateIni, tabla);
            for(int d = 1; d < dias-1; d++){
                setDay.add(Calendar.DAY_OF_YEAR, 1);
                String newDay = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
                pintarFecha(d, newDay, setDay.getTime(), tabla);
            }
        }*/
        /** Fin Generación de fechas **/
    }
    
    public String getDia(int dia){
        switch(dia){
            case 1:
                return "Lunes";
             case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 7:
                return "Domingo";
        }
        return null;
    }
    
    public void guardarCalendario(JTable tabla, JComboBox jornada){
        try {
            Conn conn = new Conn();
            model = (DefaultTableModel) tabla.getModel();
            this.jornada = (int) jornada.getSelectedItem();
            
            conn.conectar();
            for(int i = 0; i < tabla.getRowCount(); i++){
                if(model.getValueAt(i, 2) != null){
                    conn.updateData("campeonato", "fecha = '" + tabla.getValueAt(i, 2) + "', hora = '" + tabla.getValueAt(i, 4) +"', ID_CAMPO = " + idcampos.get(i), "ID = " + model.getValueAt(i, 0));
                }
            }
            conn.getConection().commit();
            conn.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GeneraCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void pintarFecha(int r, String dayOfWeek, Date dateIni, JTable tabla){
            SimpleDateFormat formatterShow = new SimpleDateFormat("yyyy-MM-dd");
            //for(int q = 0; q < totalPartidosMostrados; q++){
                if(this.jornada == (int)model.getValueAt(r, 1)){
System.out.println("dayOfWeek "+dayOfWeek);
System.out.println("tabla"+tabla.getValueAt(r, 3));
                    if(dayOfWeek.equalsIgnoreCase(tabla.getValueAt(r,3).toString())){
                        tabla.setValueAt(formatterShow.format(dateIni), r, 2);
                    }
                }
            //}
    }
    
    private boolean verificaRestriccionesCampos(int partido, JTable tabla, int jornada, String local, int campo){
        Conn conn = new Conn();
        ResultSet restricciones;
        
        conn.conectar();
        restricciones = conn.getValues("*", "restricciones r INNER JOIN equipos e ON r.ID_EQUIPO = e.ID", "", "");
        
        try {
            if((int)tabla.getValueAt(partido, 1) == jornada){
                while(restricciones.next()){
                    if(local.equals(restricciones.getString("NOMBRE"))){
                        if(campo == restricciones.getInt("ID_CAMPO")){
                            return true;
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneraCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.desconectar();
        return false;
    }
    
    /*private void generaNumerosAleatorios(int valores){
        int i=0, cantidad=valores, rango=valores;
        int arreglo[] = new int[cantidad];

        arreglo[i]=(int)(Math.random()*rango);
        for(i=1; i<cantidad; i++){
            arreglo[i]=(int)(Math.random()*rango);
            for(int j=0; j<i; j++){
                if(arreglo[i]==arreglo[j]){
                    i--;
                }
            }
        }

        for(int k=0; k<cantidad; k++){
            System.out.print((k+1)+".- "+(arreglo[k]+1)+"\n");
        } 
    }*/
    
    /*private String generaFechaAleatoria(SimpleDateFormat formatter, Date dateIni, Date dateFin){
        Date randomDate = new Date(ThreadLocalRandom.current().nextLong(dateIni.getTime(), dateFin.getTime()));      
        return formatter.format(randomDate);
    }*/
}
