package net.duijndam.doorbell.server.model;


abstract public class Device {
    protected String name;
    protected DeviceType type;
    protected boolean onLocation;

    public Device(String name, DeviceType type) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public boolean isOnLocation() {
        return onLocation;
    }

    public void setOnLocation(boolean onLocation) {
        this.onLocation = onLocation;
    }

    public abstract void receiveMessage(String message);

    public void shootSendMessage() {

    }
}
