package net.duijndam.doorbell.server.model;

import java.util.ArrayList;

public class Account {
    private String name;
    private String password;
//    private boolean doNotDisturb;
//    private boolean doNotDisturbTimer;
//    private boolean onLocation;
    private static ArrayList<Account> accounts = new ArrayList<>();
//    private ArrayList<Device> devices = new ArrayList<>();


    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

//    public static ArrayList<Account> getAccounts() {
//        return accounts;
//    }
//
//    public String getName() {
//        return name;
//    }

    public static Account getAccount(int i) {
        return accounts.get(i);
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

//    public static void removeAccount(Account account) {
//        accounts.remove(account);
//    }

//    public ArrayList<Device> getDevices() {
//        return devices;
//    }
//
//    public Device getDevice(int index) { return this.devices.get(index); }
//
//    public boolean isDoNotDisturb() {
//        return doNotDisturb;
//    }
//
//    public void setDoNotDisturb(boolean doNotDisturb) {
//        this.doNotDisturb = doNotDisturb;
//    }
//
//    public boolean isDoNotDisturbTimer() {
//        return doNotDisturbTimer;
//    }
//
//    public boolean isOnLocation() {
//        return onLocation;
//    }
//
//    public void setDoNotDisturbTimer(boolean doNotDisturbTimer) {
//        this.doNotDisturbTimer = doNotDisturbTimer;
//    }
//
//    public void setOnLocation(boolean onLocation) {
//        this.onLocation = onLocation;
//    }
//
//    public void addDevice(Device device) {
//        devices.add(device);
//    }
//
//    public void toggle() {
//        this.doNotDisturb = !this.doNotDisturb;
//    }

}

//TODO: email can't already exist
//TODO: password hashed
//TODO: password requirements
//TODO: change password



