/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kiev.surc.dpi.localgrok;

import javax.swing.SwingWorker;
import org.opensolaris.opengrok.index.Indexer;

/**
 *
 * @author i.filatov
 */
public class IndexerTask extends SwingWorker<Void, Void> {
      
    @Override
    public Void doInBackground() {
        
        setProgress(10);
               
        ConfigWrapper cw = LocalGrok.getConfigWrapper();
        
        Indexer.getInstance().main(new String[] { 
            "-R", cw.getConfigFile().getAbsolutePath(),
            "-W", cw.getConfigFile().getAbsolutePath(),
            "-P",
            "-U", "localhost:2424"
        });
        
        setProgress(11);
        
        return null;
    }

}
