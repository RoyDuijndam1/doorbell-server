package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.DigitalStateChangeListener;
import net.duijndam.doorbell.server.server.WebServer;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static Config properties;


    public static void main(String[] args) throws Exception {
//        properties = new Config(Path.of("config.properties"));
        ArrayList<HardwareListener> doorbellListeners = new ArrayList<>();
        doorbellListeners.add(new MockListener());
        doorbellListeners.add(new RaspberryPiListener());
        new Server(doorbellListeners);

    }



    //TODO: config file, port, development
    //TODO: RaspberryPiListener afmaken
    //TODO: Java.util.observable
}

