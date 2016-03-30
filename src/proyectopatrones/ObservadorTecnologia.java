/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.io.FileWriter;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

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
        CrearXML n=new CrearXML();
        Document d=n.getTecnologia();

        try{
            // new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(d, new FileWriter("server/tec.xml"));

		System.out.println("File Saved!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
