package proyectopatrones;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.jdom.JDOMException;

 
public class Proyectopatrones {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, JDOMException {
       fachadacliente cl1= new fachadacliente(1);
       cl1.actualizar();
    }
    
}