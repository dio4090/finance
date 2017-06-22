package br.com.dellectus.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.dellectus.usuario.Usuario;

public class FinanceUtils {
    public Date formataData(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  

        Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = (java.util.Date)formatter.parse(data);  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }
    
    public int validateUsuario(String login) {
    	if(login.equals(null))
    		return 0;
    	
    	if(login.equals("dio4090"))
    		return 1;
    	else
    		return 2;
    }
}
