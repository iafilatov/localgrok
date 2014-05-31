package ua.kiev.surc.dpi.localgrok;

import java.io.File;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hello world!
 *
 */
public class LocalGrok {

    private static File APP_ROOT;
    private static File CONFIG_FILE;
    private static ConfigWrapper configWrapper;
    
    private static UI ui;
    
    private static WebAppTask webAppTask = new WebAppTask();
    
    
    public static File getAppRoot() {
        return APP_ROOT;
    }

    public static ConfigWrapper getConfigWrapper() {
        return configWrapper;
    }
    
    public static void reindex() {
        IndexerTask indexerTask = new IndexerTask();
        indexerTask.addPropertyChangeListener(ui);
        indexerTask.execute();
    }
    
    private void init() {
        APP_ROOT = new File(LocalGrok.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsoluteFile().getParentFile();
        CONFIG_FILE = new File(APP_ROOT, "etc/configuration.xml");
        configWrapper = new ConfigWrapper();
        ui = new UI();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ui.setVisible(true);
            }
        });
        
        webAppTask.addPropertyChangeListener(ui);
        webAppTask.execute();
    }
   
    public static void main(String[] args) {

        new LocalGrok().init();
    }
}
