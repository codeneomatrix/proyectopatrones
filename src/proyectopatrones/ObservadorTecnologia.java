/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

/**
 *
 * @author subzero
 */
public class ObservadorTecnologia implements Observador{
    private Sujeto datos;
    ObservadorTecnologia(Sujeto s){
        this.datos=s;
        datos.registrarObservador(this);
    }

    @Override
    public void actualizar() {

    }
    
}
