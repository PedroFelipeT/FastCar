package br.com.equipe.fastcar.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Data {
    
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    public static java.sql.Date dateToDateSQL(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }
    
    public static java.util.Date dateSQLToDate(java.sql.Date dataSQL) {
        try {
            return FORMAT.parse(FORMAT.format(dataSQL));
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static java.util.Date stringToDate(String data) {
        try {
            return FORMAT.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String dateToString(java.util.Date data) {
        return FORMAT.format(data);
    }
}
