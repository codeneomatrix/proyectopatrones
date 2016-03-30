package proyectopatrones;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class crearcliente {
   
    
    cliente uno= new cliente();
    
    crearcliente(){
    //registar clientes post
    }
    public void registrar(String[] aspectos) throws MalformedURLException, UnsupportedEncodingException, IOException{
        //peticionpost post = new peticionpost ("http://192.168.1.12/addUser/post");
        peticionpost post = new peticionpost ("https://intense-reef-93631.herokuapp.com/addUser/post");
        post.add("url", "http://192.168.0.2:8080/aplicacion/update");
        post.add("nombre", "aplicacion1");
        post.add("mail", "algo@gmail.com");
        String s="";
        for(int i=0; i<aspectos.length;i++){
            if(aspectos[i].equals("tecnologia")) s+="1";
            if(aspectos[i].equals("deportes")) s+="2";
            if(aspectos[i].equals("noticias")) s+="3";
            if(i<aspectos.length-1)s+=",";
        }
        //System.out.println("intereses "+s);
        post.add("intereses",s);
        String respuesta = post.getRespueta();
        System.out.println(respuesta);
    }
    

   
    
    public void descargar(){
         Descarga d1 = new Descarga();
        
        //d1.getRSSfromURL("http://codigoprogramacion.com/feed");
    }
    public void grafica() {
     
     uno.setVisible(true);
    }
    
    
    public void actualizar(){
        uno.mi_panel.Mi_Componente();
    }
}
