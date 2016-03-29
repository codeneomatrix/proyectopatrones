package proyectopatrones;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class fachadacliente {
    crearcliente n1;
    fachadacliente() throws UnsupportedEncodingException, IOException{
       String[] d={"tecnologia","deportes"};
       n1 = new crearcliente();
       n1.registrar(d);
       n1.grafica();
    }
    
    public void actualizar(){
       n1.actualizar();
    }
    
}
