
package proyectopatrones;

import java.io.IOException;

public class navegador implements navega{
    private String url;
    
    @Override
    public void colocarurl(String ur){
        url=ur;
    }
    
    @Override
    public void openURL() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        }
    }
    
}
