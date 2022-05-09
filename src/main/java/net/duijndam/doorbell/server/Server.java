package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalState;

import java.nio.file.Path;

public class Server {
    private static HardwareListener mock;
    private static net.duijndam.doorbell.server.server.Server server;
    public static Config properties;


    public static void main(String[] args) throws Exception {
        properties = new Config(Path.of("config.properties"));
        mock = new MockListener();
        server = new net.duijndam.doorbell.server.server.Server();
        addSignalListener();
    }

    /**
     * Adds a listener to broadcast a message to all websocket clients when the doorbell is pressed
     */
    private static void addSignalListener() {
        mock.addListener(event -> {
            if(event.state().equals(DigitalState.LOW)) {
                server.broadcastMessage();
            }
        });
    }

    //TODO: config file, port, development
    //TODO: RaspberryPiListener afmaken
    //TODO: Condition Coverage test Test apart true en false
    //TODO: Decision Coverage test
    //TODO: Condition/Decision coverage test
    //TODO: Modified Condition/Decision Coverage test
}
