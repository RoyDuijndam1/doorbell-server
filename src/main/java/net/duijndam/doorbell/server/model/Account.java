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

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public static Account getAccount(String name) {
        for (Account account : accounts) {
            if (account.name.equals(name)) {
                return account;
            }
        }
        return null;
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

}

//TODO: email can't already exist
//TODO: password hashed
//TODO: password requirements
//TODO: change password



