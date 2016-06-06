package proyectopatrones;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.jdom.JDOMException;


public class fachadacliente {
    crearcliente n1;
    String[] d={"Tecnologia","Deportes"};
    String[] d1={"Tecnologia","Noticias"};
    String[] d2={"Deportes","Noticias"};
    String[] ele;
    
    fachadacliente(int eleccion) throws UnsupportedEncodingException, IOException, JDOMException{
       if(eleccion==1){
           ele=d;
       }
       if(eleccion==2){
           ele=d1;
       }
       if(eleccion==3){
           ele=d2;
       }
       
       n1 = new crearcliente(ele);
       n1.registrar(ele);
       n1.grafica();
    }
    
    public void actualizar() throws JDOMException, IOException{
       n1.actualizar();
    }
    
}
