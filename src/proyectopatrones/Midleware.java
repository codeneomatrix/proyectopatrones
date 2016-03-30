/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;
import java.sql.*;
import java.io.*;

import java.util.List;
import org.jdom.Document;         // |
import org.jdom.Element;          // |\ Librerías
import org.jdom.input.SAXBuilder;
import java.util.ArrayList;


/**
 *
 * @author subzero
 */
public class Midleware implements Sujeto{
    private ArrayList<Observador> observadores;


    Midleware(){
        observadores=new ArrayList();
    }

    @Override
    public void registrarObservador(Observador O) {
       observadores.add(O);
    }

    @Override
    public void removerObservador(Observador O) {
        if(observadores.size()>0){
            observadores.remove(O);
        }
    }

    @Override
    public void notificarObservadores(int inte){
     if(inte==1){
         for(int i=0;i<observadores.size();i++){
             Observador ob=observadores.get(i);
             if(ob instanceof ObservadorDeportes){
                 ob.actualizar();
             }
         }
     }
     if(inte==2){
         for(int i=0;i<observadores.size();i++){
             Observador ob=observadores.get(i);
             if(ob instanceof ObservadorTecnologia){
                 ob.actualizar();
             }
         }
     }
     if(inte==3){
         for(int i=0;i<observadores.size();i++){
             Observador ob=observadores.get(i);
             if(ob instanceof ObservadorNoticias){
                 ob.actualizar();
             }
         }
     }

    }



    public void insertarADB(String fi,int interes){
      String p="";
      if(interes==1){
        p=p+"deportes";
      }
      if(interes==2){
          p=p+"tecnologia";
      }
    
      if(interes==3){
        p=p+"noticias";
      }
      if(fi.length()>4 && (interes >0 && interes<4)){
  SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(fi);
    try{
    //Se crea el documento a traves del archivo
    Document document = (Document) builder.build( xmlFile );

    //Se obtiene la raiz 'tables'
    Element rootNode = document.getRootElement();

    Element canal=rootNode.getChild("channel");
    //Se obtiene la lista de hijos de la raiz 'tables'
    List list = (canal.getChildren("item"));

    //Se recorre la lista de hijos de 'tables'
    for ( int i = 0;i< list.size(); i++ ){
        //Se obtiene el elemento 'tabla'
        Element item = (Element) list.get(i);

        //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
        String guid = item.getChildText("guid");
        System.out.println( "guid: " + guid);
        String titulo = item.getChildText("title");
        System.out.println( "title: " + titulo);
        String des = item.getChildText("description");
        System.out.println( "des: " + des);
        String link = item.getChildText("link");
        System.out.println( "link: " + link);
        String pubDate = item.getChildText("pubDate");
        System.out.println( "puDate: " + pubDate);



        Connection connection = GetConnection.getConnection();

      Statement stmt = connection.createStatement();
      
      String s="INSERT INTO "+p+"(guid,titulo,descripcion,link,pubdate) VALUES(\'"+guid+"\',\'"+titulo+"\',\'"+des+"\',\'"+link+"\',\'"+pubDate+"\')";
      System.out.println(s);
      stmt.executeUpdate(s);
    }



    }

catch(Exception e){
      e.printStackTrace();
    }
        notificarObservadores(interes);
      }
  }
    public static void main(String []args){
        Midleware mi=(Midleware)new Midleware();
        Observador dep=new ObservadorDeportes(mi);
        Observador not=new ObservadorNoticias(mi);
        Observador tec=new ObservadorTecnologia(mi);
        /*for(int i =0;i<mi.observadores.size();i++){
            Observador o=mi.observadores.get(i);
            System.out.println(o.getClass());
        }*/
        mi.insertarADB("/home/subzero/Desktop/depor.xml",1);
        
    
    }
}
