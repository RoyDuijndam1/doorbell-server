package net.duijndam.doorbell.server.controller;

import io.javalin.http.HttpCode;
import net.duijndam.doorbell.server.model.Account;
import net.duijndam.doorbell.server.server.Response;

public class AccountController {

    public static Response create(String name, String password) {
        Response response = new Response();
        checkName(name, response);
        checkPassword(password, response);

        if(response.getMessages().size() == 0) {
            Account account = new Account(name, password);
            Account.addAccount(account);
            response.setHttpCode(HttpCode.CREATED);
            return response;

        } else {
            response.setHttpCode(HttpCode.BAD_REQUEST);
            return response;

        }
    }

    public static Account read() {
        int i = 1;
        return Account.getAccount(i);
    }

    public static void update() {

    }

    public static void delete() {

    }

    private static void checkName(String name, Response response) {
        if (!(name.length() < 32)) {
            response.addMessage("Name exceeds 32 characters");
        }
    }

    private static void checkPassword(String password, Response response){
        if (password.length() < 8) {
            response.addMessage("Password must be longer than 7 characters");
        }

        if(password.length() > 55) {
            response.addMessage("Password must be shorter than 56 characters");
        }

        if(!password.matches("(?=.*[0-9]).*") && !password.matches("(?=.*[~!@#$%^&*()_-]).*")) {
            response.addMessage("Password needs to contain a number or a special character");
        }
    }
}