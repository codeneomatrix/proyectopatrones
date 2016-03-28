
package proyectopatrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class iteradorconcreto implements iiterador{
    private elemento[] _vector;
    private File _a;
    private int _posicion;
 	
    public iteradorconcreto(agregado vector) {
        if (vector instanceof vectorcomponentes){
            vectorcomponentes te= (vectorcomponentes)vector;
            _vector =te._datos;
        }
        
         /*if (vector instanceof vectordisco){
            vectordisco te= (vectordisco)vector;
            _a =te.f;
        }*/
         
        _posicion = 0;
    }
 	 	
    @Override
    public boolean hasNext(){
        if (_vector!=null){
            return _posicion < _vector.length;
        }
        if (_a!=null){
            int c=0;
            try {
            
            if(_a.exists()){
           BufferedReader Flee= new BufferedReader(new FileReader(_a));
           while((Flee.readLine())!=null) {  
            c++;
           }
           Flee.close();
         }else{
           System.out.println("Fichero No Existe");
         }
        } catch (Exception ex) {}
            
            return  _posicion < c;
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
            return _vector[_posicion++];
        }
        
	if (_a!=null){
        int s=-1;
        int c=0;
        try {
            if(_a.exists()){
           BufferedReader Flee= new BufferedReader(new FileReader(_a));
           String Slinea;
          
           while((Slinea=Flee.readLine())!=null) {  
            
            if(c==_posicion){
               s=Integer.parseInt(Slinea);
            }
            c++;
           }
     
           Flee.close();
         }else{
           System.out.println("Fichero No Existe");
         }
        } catch (Exception ex) {}
        _posicion++;
        return s; }
        
        return 0; 
    }
}
