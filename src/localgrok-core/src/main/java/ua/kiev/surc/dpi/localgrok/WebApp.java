/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kiev.surc.dpi.localgrok;

import java.io.File;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author i.filatov
 */
public class WebApp {

    private static WebApp webapp = new WebApp();
    private static Server server;
    private static final int port = 2425;
    private static final String host = "localhost";
    private static String documentRoot;
    private final Logger LOG = LoggerFactory.getLogger(WebApp.class);

    public static WebApp getInstance() {
        return webapp;
    }

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

    public final void init() {
        if (server == null || !server.isRunning()) {
            server = new Server();
            
            documentRoot = new File(LocalGrok.getAppRoot(), "web/source.war").getAbsolutePath();

            WebAppContext context = new WebAppContext();
            context.setContextPath("/source");
            context.setWar(documentRoot);
            context.setInitParameter("CONFIGURATION", LocalGrok.getConfigWrapper().getConfigFile().getAbsolutePath());
            server.setHandler(context);
        }
    }
    
    public void doStart() throws Exception {
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setHost(host);
        connector.setPort(port);
        
        server.setConnectors(new SelectChannelConnector[] {connector});

        LOG.debug("Starting Jetty Server");
        
        server.start();
    }
    
    public void doJoin() throws Exception {
        server.join();
    }
    
    public void doStop() throws Exception {
        LOG.debug("Stopping Jetty Server");

        server.stop();
    }

    public WebApp() {
        init();
    }
}
