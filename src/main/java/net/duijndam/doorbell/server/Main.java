package net.duijndam.doorbell.server;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
//    public static Config properties;


    public static void main(String[] args) throws Exception {
//        properties = new Config(Path.of("config.properties"));
        ArrayList<HardwareListener> doorbellListeners = new ArrayList<>();
        doorbellListeners.add(new MockListener());

        /* Only add the Raspberry Pi listener when running on a Raspberry Pi / ARM */
        if (Arrays.asList("arm", "arm64", "armhf", "aarch64").contains(System.getProperty("os.arch"))) {
            doorbellListeners.add(new RaspberryPiListener());
        }

        new Server(doorbellListeners);

    }



    //TODO: config file, port, development
    //TODO: RaspberryPiListener afmaken
    //TODO: Java.util.observable
}

