package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jmux.Http;

import java.io.IOException;

public class DeleteJob implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String response = "DeleteJob 1";
        Http.sendResponse(exchange, 200, response.getBytes());
    }
}
