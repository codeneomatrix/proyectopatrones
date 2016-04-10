package proyectopatrones;

import static com.sun.javafx.PlatformUtil.isWindows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class paneldinamico extends JPanel implements ActionListener {

    private int maxnoticias=8;
    private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private vectorcomponentes nota = new vectorcomponentes(maxnoticias);
    private String[] d;
     private Container c;
    private JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    private JPanel amostrar = new javax.swing.JPanel();
    
    public paneldinamico(String[] aspectos)
    {   
        d=aspectos;
        this.setSize(1300, 550);
        //this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder( Color.BLACK ));
        this.setLayout( new FlowLayout() );
        jScrollPane1.setViewportView(this);
        
        //getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);
        
    }

    public void prueba(){
         JOptionPane.showMessageDialog(null, "DEsde maven!!!!!!!!!!!!! ");
    }
        
    public void Mi_Componente() throws FileNotFoundException, JDOMException, IOException
    {        
        if(index==maxnoticias){
            this.removeAll(); 
            this.repaint();
            index=1;
        }
        
   
        for(int j=0; j<d.length;j++ ){
        Descarga ac = new Descarga();
        
         ac.getRSSfromURL("https://intense-reef-93631.herokuapp.com/getXML/"+d[j],d[j]);
         File inputFile = new File(d[j]+".xml");
         
         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(inputFile);
         List root = (List) document.getRootElement().getChildren("channel");
         Element node = (Element) root.get(0);
         List listitems = node.getChildren("item");
         
         for (int i = 0; i < listitems.size(); i++) {
        if(index<maxnoticias/(d.length-j)){
            elemento jpc = new elemento(index);

             Element nodeitem = (Element) listitems.get(i);
             jpc.jLabel1.setText(nodeitem.getChildText("title"));
             jpc.jLabel3.setText(nodeitem.getChildText("link"));
             jpc.jLabel3.setVisible(false);
             String da= nodeitem.getChildText("description");
             if(da.length()<150){
                 jpc.jLabel2.setText(nodeitem.getChildText("description"));
             }else{
                 jpc.jLabel2.setText(nodeitem.getChildText("link"));
             }
             jpc.jButton2.addActionListener(this);
             this.add(jpc);
             this.validate();
        
             this.nota.colocar(index,jpc );
             index++;
	    }
        }
        }
        
         

        
    }
    
     

    public void actionPerformed(ActionEvent e) {
        navega nnv;
        if(isWindows()){
            nnv = new crearnavegador().obtenernavegador("windows");
        }else{
            nnv = new crearnavegador().obtenernavegador("linux");
        }
        
        String comando = e.getActionCommand();
        iiterador it = nota.creariterador();
        while (it.hasNext()) {            
            String itm = it.getKey();
             if( itm.equals(comando))
            {   
                elemento entry = (elemento)it.next();
                //JOptionPane.showMessageDialog(null, "Se presiono boton " + itm + " \n "+entry.jLabel3.getText());
                nnv.colocarurl(entry.jLabel3.getText());
                nnv.openURL();
            }
       
     
        }
    }

    

}
