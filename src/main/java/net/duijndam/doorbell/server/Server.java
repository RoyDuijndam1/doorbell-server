package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.DigitalStateChangeListener;
import net.duijndam.doorbell.server.server.WebServer;

import java.util.List;

public class Server {
    private final List<HardwareListener> doorbellListeners;
    private static WebServer webServer;


    public Server(List<HardwareListener> hardwareListeners) {
        doorbellListeners = hardwareListeners;
        webServer = new WebServer();
        addSignalListener();
    }

    /**
     * Adds a listener to broadcast a message to all websocket clients when the doorbell is pressed
     */
    private void addSignalListener() {
        DigitalStateChangeListener observer = event -> {
            if(event.state().equals(DigitalState.LOW)) {
                webServer.broadcastMessage();
            }
        };

        for (var doorbellListener: doorbellListeners) {
            doorbellListener.addListener(observer);
        }
    }
}
