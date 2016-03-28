package proyectopatrones;

public class vectorcomponentes implements agregado {
    public elemento[] _datos;

    public vectorcomponentes(int valores){ 
        _datos = new elemento[valores];
        
    }    
    
    @Override
    public elemento getValor(int pos){ 
        return _datos[pos]; 
    }
    
    @Override
    public void colocar(int pos, elemento valor) {
        _datos[pos] = valor; 
    }

    @Override
    public int dimension(){ 
        return _datos.length; 
    }
    
    @Override
    public iiterador creariterador(){
        return new iteradorconcreto(this); 
    }

    

}

