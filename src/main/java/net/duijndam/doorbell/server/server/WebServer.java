package net.duijndam.doorbell.server.server;

import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
import net.duijndam.doorbell.server.controller.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WebServer {
    private final List<WsContext> userList = Collections.synchronizedList(new ArrayList<>());
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServer.class);


    /**
     * Create a Javalin app and set rules for how to react on: on connect, on close and on error.
     * On Connect: add user to user list
     * On close: remove user from user list
     */
    public WebServer() {
        Javalin app = Javalin.create().start(80);
        app.ws("/bell", ws -> {
            ws.onConnect(ctx -> {
                userList.add(ctx);
                LOGGER.info("user connected");
            });

            ws.onClose(ctx -> {
                userList.remove(ctx);
                LOGGER.info("user disconnected");

            });
            ws.onError(ctx -> LOGGER.error("Error: ", ctx.error()));
        });

        //TODO: make handler groups
        //TODO: add to documentation
        //TODO: look into error stream

        app.post("/account", ctx -> ctx.json(AccountController.create(ctx.attribute("name"), ctx.attribute("password"))));
        app.get("/account", ctx -> ctx.json(AccountController.read(ctx.attribute("name"), ctx.attribute("password"))));
        app.put("/account", ctx -> ctx.json( AccountController.update(ctx.attribute("name"), ctx.attribute("password"))));
        app.delete("/account", ctx -> ctx.json(AccountController.delete(ctx.attribute("name"), ctx.attribute("password"))));
        app.exception(Exception.class, (e, ctx) -> ctx.json(e.getMessage()));
    }

    /**
     * sends a message to all the users in the user list
     */
    public void broadcastMessage() {
        userList.stream().filter(ctx ->ctx.session.isOpen()).forEach(session -> session.send("De bel gaat"));
    }
}


