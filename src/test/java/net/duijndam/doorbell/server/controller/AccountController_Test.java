package net.duijndam.doorbell.server.controller;

import net.duijndam.doorbell.server.server.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AccountController_Test {

    @Test
    public void password_test_more_than_8_letters_and_a_number() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "wachtwoord2");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_more_than_8_letters_and_a_special_character() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "wachtwoord!");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_less_than_8_letters_and_a_number_and_a_special_character() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password must be longer than 7 characters");
        Response response = AccountController.create("Henk", "w@cht2");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_more_than_8_letters() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password needs to contain a number or a special character");
        Response response = AccountController.create("Henk", "wachtwoord");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_6_characters() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password must be longer than 7 characters");
        Response response = AccountController.create("Henk", "1@chtw");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_7_characters() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password must be longer than 7 characters");
        Response response = AccountController.create("Henk", "1@chtwo");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_8_characters() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "1@chtwoo");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_9_characters() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "1@chtwoor");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_54_characters() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "1@chtwoordwachtwoordwachtwoordwachtwoordwachtwoordwach");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_55_characters() {
        ArrayList<String> messages = new ArrayList<>();
        Response response = AccountController.create("Henk", "1@chtwoordwachtwoordwachtwoordwachtwoordwachtwoordwacht");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_56_characters() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password must be shorter than 56 characters");
        Response response = AccountController.create("Henk", "1@chtwoordwachtwoordwachtwoordwachtwoordwachtwoordwachtw");
        Assert.assertEquals(messages, response.getMessages());
    }

    @Test
    public void password_test_with_57_characters() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Password must be shorter than 56 characters");
        Response response = AccountController.create("Henk", "1@chtwoordwachtwoordwachtwoordwachtwoordwachtwoordwachtwo");
        Assert.assertEquals(messages, response.getMessages());
    }
}
