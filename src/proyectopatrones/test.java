/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author subzero
 */
public class test {
    public static void main(String[]args){
     Descarga d=new Descarga();
     //d.getRSSfromURL("http://marca.feedsportal.com/rss/futbol_1adivision.xml");
     d.getRSSfromURL("http://www.eluniversal.com.mx/rss/mexico.xml");
     
     //String cad=leer();
     //System.out.println(cad);
        
    }
    static String leer(){
      String archivo="rss.xml";
      String cadena="";
      try{
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while(( b.readLine())!=null) {
            cadena+=b.readLine();
            cadena+="\n";
            
        }
        b.close();

      }
      catch(Exception e){
        e.printStackTrace();
      }
      return cadena;
    }
}
