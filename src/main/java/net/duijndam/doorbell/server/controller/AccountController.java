package net.duijndam.doorbell.server.controller;

import io.javalin.http.HttpCode;
import net.duijndam.doorbell.server.model.Account;
import net.duijndam.doorbell.server.server.Response;

import java.util.ArrayList;

public class AccountController {

    public static Response create(String name, String password) {
        Response response = new Response();
        checkName(name, response);
        checkPassword(password, response);

        if(response.getMessages().size() == 0) {
            Account account = new Account(name, password);
            Account.addAccount(account);
            response.setHttpCode(HttpCode.CREATED);

        } else {
            response.setHttpCode(HttpCode.BAD_REQUEST);

        }
        return response;
    }

    public static Response read(String name, String password) throws Exception {
        return generateResponse(name, password);
    }

    public static Response update(String name, String password) throws Exception {
        Response response = generateResponse(name, password);

        response.getAccount().setName(name);
        response.getAccount().setPassword(password);

        return response;
    }

    public static Response delete(String name, String password) throws Exception {
        Response response = generateResponse(name, password);

        Account.getAccounts().remove(response.getAccount());

        return response;
    }

    private static Response generateResponse(String name, String password) throws Exception {
        Response response = new Response();
        doesNameExists(name);
        Account account = Account.getAccount(name);
        passwordEqualsAccountPassword(account, password);
        response.setHttpCode(HttpCode.OK);
        return response;
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

    private static void doesNameExists(String name) throws Exception {
        ArrayList<Account> accounts = Account.getAccounts();
        for (Account account : accounts )  {
            if(account.getName().equals(name)) {
                return ;
            }
        }
        throw new Exception("Name does not exist");
    }

    private static void passwordEqualsAccountPassword(Account account, String password) throws Exception {
        if (account != null && account.getPassword().equals(password)) {
            throw new Exception("Wrong password");
        }
    }

}