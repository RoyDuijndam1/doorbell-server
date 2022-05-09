package net.duijndam.doorbell.server.server;

import io.javalin.http.HttpCode;

import java.util.ArrayList;

public class Response {
    private HttpCode httpCode;
    private ArrayList<String> messages = new ArrayList<>();

    public HttpCode getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpCode httpCode) {
        this.httpCode = httpCode;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }
}
