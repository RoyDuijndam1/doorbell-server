package net.duijndam.doorbell.server.model;

public class PC extends Device{
    public PC(String name) {
        super(name, DeviceType.PC);
    }

    @Override
    public void receiveMessage(String message) {

    }
}
