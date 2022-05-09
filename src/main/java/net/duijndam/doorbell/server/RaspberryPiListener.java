package net.duijndam.doorbell.server;

public class RaspberryPiListener extends HardwareListener {

    public RaspberryPiListener() {
        super("pigpio-digital-input");
    }

    @Override
    void setup() {

    }
}
