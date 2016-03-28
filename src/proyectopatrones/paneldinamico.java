package proyectopatrones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class paneldinamico extends JPanel implements ActionListener {

    private int maxnoticias=5;
    private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private vectorcomponentes nota = new vectorcomponentes(maxnoticias);
    
     private Container c;
    private JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    private JPanel amostrar = new javax.swing.JPanel();
    
    public paneldinamico()
    {
        this.setSize(1300, 550);
        //this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder( Color.BLACK ));
        this.setLayout( new FlowLayout() );
        jScrollPane1.setViewportView(this);
        
        //getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);
        
    }

    
        
    public void Mi_Componente()
    {        
        if(index<maxnoticias){
        elemento jpc = new elemento(index);
        jpc.jLabel1.setText(" Lo mï¿½s visto: Filtran imï¿½genes del iPhone 6S");
        jpc.jLabel2.setText("Muestran varias imï¿½genes en las que se aprecian diversas caracterï¿½sticas del nuevo terminal de Apple");
        jpc.jButton2.addActionListener(this);
        this.add(jpc);
        this.validate();
        
        this.nota.colocar(index,jpc );
        index++;
        }
        
        
    }
    
     public static void openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + url);
            } else {
                System.out.println("Please open a browser and go to "+ url);
            }
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        iiterador it = nota.creariterador();
        while (it.hasNext()) {            
            String itm = it.getKey();
             if( itm.equals(comando))
            {
                JOptionPane.showMessageDialog(null, "Se presiono boton " + itm + " \n Hola ");
                openURL("http://www.eluniversal.com.mx/computacion-tecno/2015/visto-imagenes-iphone-6s-107889.html");
            }
        //elemento entry = (elemento)it.next();
     
        }
    }

    

}
