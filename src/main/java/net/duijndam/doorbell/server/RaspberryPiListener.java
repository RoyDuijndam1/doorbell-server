package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalInputConfigBuilder;

public class RaspberryPiListener extends HardwareListener {

    @Override
    void setup(DigitalInputConfigBuilder buttonBuilder) {
        buttonBuilder.provider("pigpio-digital-input");
    }
}
