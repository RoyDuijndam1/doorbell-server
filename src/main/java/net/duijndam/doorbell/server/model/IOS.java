package net.duijndam.doorbell.server.model;

public class IOS extends Device{
    public IOS(String name) {
        super(name, DeviceType.IOS);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.name + " " + message);
    }
}
