/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kiev.surc.dpi.localgrok;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opensolaris.opengrok.configuration.Configuration;
import org.slf4j.LoggerFactory;

/**
 *
 * @author i.filatov
 */
public class ConfigWrapper {
   
    private static Configuration configuration;
    private static final File CONFIG_FILE = new File(LocalGrok.getAppRoot(), "etc/configuration.xml");
    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(WebApp.class);


    public void setSourceRoot(String sourceRoot) {
        synchronized (configuration) {
            configuration.setSourceRoot(sourceRoot);
        }
    }

    static public Configuration getConfiguration() {
        return configuration;
    }
    
    public final void write(){
        synchronized(configuration) {
            try {
                configuration.write(CONFIG_FILE);
            } catch (Exception ex) {
                LOG.info("Failed to write config file");
                LOG.debug(ex.getMessage());
            }
        }
    }

    public static File getConfigFile() {
        return CONFIG_FILE;
    }
        
    
    private void setDefaults() {
        if (configuration != null) {
            synchronized (configuration) {
                // TODO Set some defaults here
            }            
        }
    }


    
    
    public ConfigWrapper() {

        /* Need to check if config file exists and has essential parameters.
         * If not, we'll have to set some dafaults.
         */
        try {
            configuration = Configuration.read(CONFIG_FILE);
        } catch (Exception ex) {
            LOG.info("Failed to read config file, will use dafaults");
            LOG.debug(ex.getMessage());
            
            configuration = new Configuration();
            setDefaults();
        } 
        
        configuration.setDataRoot(LocalGrok.getAppRoot().getAbsolutePath());
        
        write();
    }
}
