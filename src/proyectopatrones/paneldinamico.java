package proyectopatrones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class paneldinamico extends JPanel implements ActionListener {

    private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private Map nota = new HashMap();
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
        //instancia nueva a componente
        elemento jpc = new elemento(index);
        jpc.jLabel1.setText(""+index);
        jpc.jButton2.addActionListener(this);//escucha eventos
        this.add(jpc);//se añade al jpanel
        System.out.println("ceando esta schingaderas!!!!!!!!!!!");
        this.validate();
        //se añade al MAP
        this.nota.put("key_" + index, jpc );
        //se incrementa contador de componentes
        index++;
        
        
    }

    public void actionPerformed(ActionEvent e) {
        //se obtiene el comando ejecutado
        String comando = e.getActionCommand();
        //se recorre el MAP
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            //se obtiene el KEY -> identificador unico
            String itm = entry.getKey().toString();
            //si comando de componente es igual a comando pulsado
            if( itm.equals(comando))
            {
                //se recupera el contenido del JTextfield
                
                //mostramos resultado
                JOptionPane.showMessageDialog(null, "Se presiono boton " + itm + " \n Hola ");
            }
        }
    }

    

}
