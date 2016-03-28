
package proyectopatrones;

import java.io.IOException;

public class navegadormac implements navega{
    private String url;
    
    @Override
    public void colocarurl(String ur){
        url=ur;
    }
    
    @Override
    public void openURL() {
        try {
            Runtime.getRuntime().exec("open " + url);
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        }
    }
}
