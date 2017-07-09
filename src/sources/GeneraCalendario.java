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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santy
 */
public class GeneraCalendario {
    class oCampeonato{
        int id;
        int jornada;
        String fecha;
        String hora;
        int local;
        int visitante;
        int jugado;
        public oCampeonato(Object[] datos){
            this.id = (int) datos[0];
            this.jornada = (int) datos[1];
            this.fecha = (String) datos[2];
            this.hora = (String) datos[3];
            this.local = (int) datos[4];
            this.visitante = (int) datos[5];
            this.jugado = (int) datos[6];
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
    }
       
    private final String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miércoles",
        			    "Jueves", "Viernes", "Sábado"};
    private int totalCamposDisponibles;
    private int totalHorariosDisponibles;
    private int totalPartidosMostrados;
    private int jornada;
    private ResultSet campeonato;
    private ResultSet restricciones;
    private ResultSet camposDis;
    private ArrayList<oCampeonato> arrCampeonato;
    private ArrayList<oRestricciones> arrRestricciones;
  
    public void generaFechas(String fInicio, String fFin, JTable tabla, JComboBox jornada){
        Conn conn = new Conn();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        this.jornada = (int) jornada.getSelectedItem();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        String dateInString = fInicio;
        String dateFinString = fFin;
        //Calendar cInicio = Calendar.getInstance();
        //Calendar cFin = Calendar.getInstance(); 
        
        conn.conectar();
        totalHorariosDisponibles = conn.totalRegistros("campos INNER JOIN cam_horarios ON ID = ID_CAMPO", "CONGELADO = 0");
        totalCamposDisponibles = conn.totalRegistros("campos", "CONGELADO = 0");
        campeonato = conn.getValues("*", "campeonato", "", "JORNADA");
        restricciones = conn.getValues("*", "restricciones", "", "");
        camposDis = conn.getValues("*", "campos INNER JOIN cam_horarios ON ID = ID_CAMPO", "CONGELADO = 0", "");
        
        try{
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
        }
        
        /** Reparto de campos **/
        totalPartidosMostrados = model.getRowCount();
        boolean jornadaCorrecta = false;
        //System.out.println("Campos " +totalCamposDisponibles);
        //System.out.println("Horarios " +totalHorariosDisponibles);
        for(int d = 0; d < totalPartidosMostrados; d++){
            if(this.jornada == (int)model.getValueAt(d, 1)){
                jornadaCorrecta = true;
                if(totalHorariosDisponibles >= totalPartidosMostrados){
                //if(totalHorariosDisponibles >= contadorPartidos){
                    //System.out.println("Hay suficientes horarios para los partidos");
                    try{
                        for(int p = 0; p < totalPartidosMostrados; p++){
                            camposDis.next();
                            tabla.setValueAt(camposDis.getString("CAMPO"), p, 7);
                            tabla.setValueAt(getDia(camposDis.getInt("ID_DIA")), p, 3);
                            tabla.setValueAt(camposDis.getInt("ID_HORA"), p, 4);   
                        }
                        while (camposDis.next()){
                            //System.out.println("ID campos " + camposDis.getInt("ID") + " ID_DIA " + camposDis.getInt("ID_DIA"));
                        }
                    }catch(SQLException ex){
                        //System.err.println(ex.getCause());
                    }
                }else{
                    jornadaCorrecta = false;
                    JOptionPane.showMessageDialog(null, "NO hay suficientes horarios para los partidos mostrados", "Insuficientes horarios", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        //System.out.println("Partidos "+contadorPartidos);
        conn.desconectar();
        
        /** Fin reparto de campos **/
        
        /** Generación de fechas según campo asignado **/
        if(jornadaCorrecta){
            try{
                Date dateIni = formatter.parse(dateInString);
                Date dateFin = formatter.parse(dateFinString);
                //cInicio.setTime(dateIni);
                //cFin.setTime(dateFin);
                Calendar setDay = Calendar.getInstance();
                int dias=(int) ((dateFin.getTime()- dateIni.getTime())/86400000) + 1;


                setDay.setTime(dateIni);
                //System.out.println("Inicio "+dateIni);
                String dayOfWeek = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
                //System.out.println(dayOfWeek);
                pintarFecha(dayOfWeek, dateIni, tabla);
                for(int d = 0; d < dias-1; d++){  
                    //System.out.println("Dia "+dateIni);
                    setDay.add(Calendar.DAY_OF_YEAR, 1);
                    String newDay = strDays[setDay.get(Calendar.DAY_OF_WEEK)-1];
                    pintarFecha(newDay, setDay.getTime(), tabla);
                    //System.out.println("Nuevo dia "+setDay.getTime());
                    //System.out.println(strDays[setDay.get(Calendar.DAY_OF_WEEK)-1]);
                }

            }catch(ParseException ex){

            }
        }
        /*try {
            totalPartidosMostrados = model.getRowCount();
            Date dateIni = formatter.parse(dateInString);
            Date dateFin = formatter.parse(dateFinString);
            cInicio.setTime(dateIni);
            cFin.setTime(dateFin);
            Calendar setDay = Calendar.getInstance();
            //int dia;
            //int dias=(int) ((dateFin.getTime()- dateIni.getTime())/86400000) + 1;
            int day;
            for(int i = 0; i < totalPartidosMostrados; i++){
                if(this.jornada == (int)model.getValueAt(i, 1)){
                    
                    String fecha = generaFechaAleatoria(formatter, dateIni, dateFin);
                    tabla.setValueAt(fecha, i, 2);
                    setDay.setTime(formatter.parse(fecha));
                    day = setDay.get(Calendar.DAY_OF_WEEK)-1;
                    tabla.setValueAt(strDays[day], i, 3);
                    
                    for(int e = 0; e < arrCampeonato.size(); e++){
                        //int numDia = 0;
                        int local = 0;
                        int visitante = 0;
                        if((int)model.getValueAt(i, 0) == arrCampeonato.get(e).id){
                            local = arrCampeonato.get(e).local;
                            visitante = arrCampeonato.get(e).visitante;
                        }
                        for(int r = 0; r < arrRestricciones.size(); r++){
                            
                            if(arrRestricciones.get(r).id_equipo == local){
                                
                                if(arrRestricciones.get(r).id_dia != 0){
                                    boolean rest = true;
                                    
                                   do{
                                       
                                        if(model.getValueAt(i, 3).equals(getDia(arrRestricciones.get(r).id_dia))){   
                                            System.out.println("Local " + arrRestricciones.get(r).id_equipo +" no puede jugar en fecha anterior " + formatter.format(setDay.getTime()));
                                            
                                            /** Genero otra fecha aleatoria **/
        /*                                  fecha = generaFechaAleatoria(formatter, dateIni, dateFin);
                                            setDay.setTime(formatter.parse(fecha));                                            
                                            tabla.setValueAt(fecha, i, 2);
                                            day = setDay.get(Calendar.DAY_OF_WEEK)-1;
                                            tabla.setValueAt(strDays[day], i, 3);
                                            System.out.println("Nueva fecha " + formatter.format(setDay.getTime()));
                                            System.out.println();
                                            r = 0;                                       
                                        }else{
                                            rest = false;
                                        }
                                    }while(rest);
                                }
                            }
                            if(arrRestricciones.get(r).id_equipo == visitante){
                                
                                if(arrRestricciones.get(r).id_dia != 0){
                                    boolean rest = true;
                                    
                                    do{
                                        if(model.getValueAt(i, 3).equals(getDia(arrRestricciones.get(r).id_dia))){
                                            
                                            System.out.println("visitante " + arrRestricciones.get(r).id_equipo +" no puede jugar en fecha anterior " + formatter.format(setDay.getTime()));
                                            /** Genero otra fecha aleatoria **/
        /*                                  fecha = generaFechaAleatoria(formatter, dateIni, dateFin);                                           
                                            setDay.setTime(formatter.parse(fecha));
                                            tabla.setValueAt(fecha, i, 2);
                                            day = setDay.get(Calendar.DAY_OF_WEEK)-1;
                                            tabla.setValueAt(strDays[day], i, 3);
                                            System.out.println("Nueva fecha " + formatter.format(setDay.getTime()));
                                            System.out.println();
                                            r = 0;                                       
                                        }else{
                                            rest = false;
                                        }
                                    }while(rest);
                                } 
                            }
                        }
                    }
                    //int campo = ThreadLocalRandom.current().nextInt(totalCamposDisponibles)+1;
                    //System.out.println(campo);
                }
            }
        } catch (ParseException e) {
        }*/
        /** Fin generación de fechas aleatorias **/
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
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            this.jornada = (int) jornada.getSelectedItem();
            
            conn.conectar();
            for(int i = 0; i < tabla.getRowCount(); i++){
                if(model.getValueAt(i, 2) != null){
                    conn.updateData("campeonato", "fecha = '" + model.getValueAt(i, 2) + "'", "ID = " + model.getValueAt(i, 0));
                }
            }
            conn.getConection().commit();
            conn.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GeneraCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void pintarFecha(String dayOfWeek, Date dateIni, JTable tabla){
        SimpleDateFormat formatterShow = new SimpleDateFormat("dd-MM-yyyy");
        for(int q = 0; q < totalPartidosMostrados; q++){
            if(dayOfWeek.equalsIgnoreCase(tabla.getValueAt(q,3).toString())){
                tabla.setValueAt(formatterShow.format(dateIni), q, 2);
            }
        }
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
