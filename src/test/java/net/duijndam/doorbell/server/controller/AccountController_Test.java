package net.duijndam.doorbell.server.controller;

import net.duijndam.doorbell.server.model.Account;
import net.duijndam.doorbell.server.server.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AccountController_Test {

    @Test
    public void create_an_account() {
        AccountController.create("Henk", "wachtwoord2");
        ArrayList<Account> accounts = Account.getAccounts();
        Assert.assertEquals(accounts.get(0).getName(), "Henk");
    }

    @Test
    public void read_an_account() {
        AccountController.create("Henk", "wachtwoord2");
        ArrayList<Account> accounts = Account.getAccounts();
        Response response = AccountController.read("Henk", "wachtwoord2");
        Assert.assertEquals(response.getAccount(), accounts.get(0));
    }

    @Test
    public void update_an_account() {

    }

    @Test
    public void delete_an_account() {

    }

}
