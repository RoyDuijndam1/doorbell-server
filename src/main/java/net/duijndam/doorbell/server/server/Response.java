package net.duijndam.doorbell.server.server;

import io.javalin.http.HttpCode;
import net.duijndam.doorbell.server.model.Account;

import java.util.ArrayList;

public class Response {
    private HttpCode httpCode;
    private final ArrayList<String> messages = new ArrayList<>();
    private Account account;

    public void setHttpCode(HttpCode httpCode) {
        this.httpCode = httpCode;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
