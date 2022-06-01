//package net.duijndam.doorbell.server.controller;
//
//import net.duijndam.doorbell.server.model.*;
//import net.duijndam.doorbell.server.server.Server;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class MessageBroker_Test {
//    Account account;
//
//    @Before
//    public void beforeTest() {
//        account = new Account("Henk", "w@chtwoord2");
//    }
//
//    /**
//     * Tests for the sendMessage method, checks different outcomes
//     * parameters DeviceType, doNotDisturb, onLocation, doNotDisturbTimer
//     */
//    @Test
//    public void message_test_PC_true_true_true() {
//        account.addDevice(new PC("Henk PC"));
//        account.setDoNotDisturb(true);
//        account.setOnLocation(true);
//        account.setDoNotDisturbTimer(true);
//        Server.sendMessage(account);
//        Assert.assertEquals("geen bericht", Server.sendMessage(account));
//    }
//
//    @Test
//    public void message_test_PC_false_false_false() {
//        account.addDevice(new PC("Henk PC"));
//        account.setDoNotDisturb(false);
//        account.setOnLocation(false);
//        account.setDoNotDisturbTimer(false);
//        Server.sendMessage(account);
//        Assert.assertEquals("geen bericht", Server.sendMessage(account));
//    }
//
//    @Test
//    public void message_test_Android_true_false_true() {
//        account.addDevice(new Android("Henk Android"));
//        account.setDoNotDisturb(true);
//        account.setOnLocation(false);
//        account.setDoNotDisturbTimer(true);
//        Server.sendMessage(account);
//        Assert.assertEquals("geen bericht", Server.sendMessage(account));
//    }
//
//    @Test
//    public void message_test_Android_false_true_false() {
//        account.addDevice(new Android("Henk Android"));
//        account.setDoNotDisturb(false);
//        account.setOnLocation(true);
//        account.setDoNotDisturbTimer(false);
//        Server.sendMessage(account);
//        Assert.assertEquals("Android bericht", Server.sendMessage(account));
//    }
//
//    @Test
//    public void message_test_IOS_true_true_false() {
//        account.addDevice(new IOS("Henk IOS"));
//        account.setDoNotDisturb(true);
//        account.setOnLocation(true);
//        account.setDoNotDisturbTimer(false);
//        Server.sendMessage(account);
//        Assert.assertEquals("geen bericht", Server.sendMessage(account));
//    }
//
//    @Test
//    public void message_test_PC_false_false_true() {
//        account.addDevice(new IOS("Henk IOS"));
//        account.setDoNotDisturb(false);
//        account.setOnLocation(false);
//        account.setDoNotDisturbTimer(true);
//        Server.sendMessage(account);
//        Assert.assertEquals("geen bericht", Server.sendMessage(account));
//    }
//}
