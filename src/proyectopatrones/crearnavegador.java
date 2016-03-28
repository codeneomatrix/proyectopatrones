
package proyectopatrones;

public class crearnavegador {
    
    public navega obtenernavegador(String nav){
        if(nav.equals("mac")){
            return new navegadormac();
        }
        if(nav.equals("linux")){
            return new navegadormac();
        }
        return new navegador();
    }
    
}
