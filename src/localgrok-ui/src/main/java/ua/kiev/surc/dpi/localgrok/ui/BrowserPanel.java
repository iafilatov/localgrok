/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kiev.surc.dpi.localgrok.ui;

import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JPanel;

/**
 *
 * @author i.filatov
 */
public class BrowserPanel extends JPanel {

    private Stage stage;
    private JFXPanel jfxPanel;
    private WebEngine webEngine;

    public void load(String url) {
        createScene(url);
    }

    public BrowserPanel() {
        initComponents();
    }

    private void initComponents() {

        jfxPanel = new JFXPanel();
        //createScene();

        setLayout(new BorderLayout());
        add(jfxPanel, BorderLayout.CENTER);
    }

    private void createScene(String url) {
        final String _url = url;
        
        PlatformImpl.startup(new Runnable() {
            public void run() {

                stage = new Stage();

                stage.setTitle("LocalGrok");
                stage.setResizable(false);

                Group root = new Group();
                Scene scene = new Scene(root, 80, 20);
                stage.setScene(scene);

                /*WebView browser = new WebView();
                browser.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

                    public void handle(ContextMenuEvent t) {
                        // Do nothing
                    }
                });

                webEngine = browser.getEngine();
                webEngine.load(_url);
                
                root.getChildren().add(browser);

                jfxPanel.setScene(scene);
            }
        });
    }
}
