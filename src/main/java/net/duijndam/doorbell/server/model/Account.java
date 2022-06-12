package net.duijndam.doorbell.server.model;

import java.util.ArrayList;

public class Account {
    private String name;
    private String password;
    private static final ArrayList<Account> accounts = new ArrayList<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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



