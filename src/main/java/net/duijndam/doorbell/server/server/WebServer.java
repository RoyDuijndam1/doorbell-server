package net.duijndam.doorbell.server.server;

import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
import net.duijndam.doorbell.server.controller.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WebServer {
    private List<WsContext> userList = Collections.synchronizedList(new ArrayList<WsContext>());
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServer.class);


    /**
     * Create a Javalin app and set rules for how to react on: on connect, on close and on error.
     * On Connect: add user to userlist
     * On close: remove user from userlist
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
        //TODO: look into errorstream

        app.post("/account", ctx -> {
            Response response = AccountController.create(ctx.attribute("name"), ctx.attribute("password"));
            ctx.json(response);
        });
        app.get("/account", ctx -> {
            Response response = AccountController.read(ctx.attribute("name"), ctx.attribute("password"));
            ctx.json(response);
        });
        app.put("/account", ctx -> {
            Response response = AccountController.update(ctx.attribute("name"), ctx.attribute("password"));
            ctx.json(response);
        });
        app.delete("/account", ctx -> {
            Response response = AccountController.delete(ctx.attribute("name"), ctx.attribute("password"));
            ctx.json(response);
        });
    }

    /**
     * sends a message to all the users in the userlist
     */
    public void broadcastMessage() {
        userList.stream().filter(ctx ->ctx.session.isOpen()).forEach(session -> session.send("De bel gaat"));
    }
}


