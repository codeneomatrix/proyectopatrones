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
public interface Sujeto {
    public void registrarObservador(Observador O);
    public void removerObservador(Observador O);
    public void notificarObservadores(int i);
    
}
