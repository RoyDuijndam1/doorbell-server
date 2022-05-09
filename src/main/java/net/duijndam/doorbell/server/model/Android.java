package net.duijndam.doorbell.server.model;

public class Android extends Device {
    public Android(String name) {
        super(name, DeviceType.ANDROID);
    }


    @Override
    public void receiveMessage(String message) {
        System.out.println(this.name + " " + message);
    }
}
