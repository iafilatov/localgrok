/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kiev.surc.dpi.localgrok;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;


public class WebAppTask extends SwingWorker<Void, Void> {

    @Override
    public Void doInBackground() {
              
        WebApp webapp = WebApp.getInstance();

        try {
            try {
                setProgress(1);
                webapp.doStart();
                setProgress(2);
                webapp.doJoin();
            } catch (InterruptedException ex) {
                setProgress(3);
                webapp.doStop();
                setProgress(4);
            }
        } catch (Exception ex) {
            setProgress(50);
            Logger.getLogger(LocalGrok.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

        
        return null;
    }
}
