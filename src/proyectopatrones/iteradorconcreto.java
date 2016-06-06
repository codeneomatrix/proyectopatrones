
package proyectopatrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class iteradorconcreto implements iiterador{
    private elemento[] _vector;

    private int _posicion;
 	
    public iteradorconcreto(agregado vector) {
        if (vector instanceof vectorcomponentes){
            vectorcomponentes te= (vectorcomponentes)vector;
            _vector =te._datos;
        }

        _posicion = 0;
    }
 	 	
    @Override
    public boolean hasNext(){
        if (_vector!=null){
            return _posicion < _vector.length;
        }
       
        return false;
    }
    
    @Override
    public String getKey(){
        return "key_"+_posicion++;
    }
    
    @Override
    public Object next(){
        if (_vector!=null){
            int pr =_posicion-1;
            return _vector[pr];
        }
      
        return 0; 
    }
}
