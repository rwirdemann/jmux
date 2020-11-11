package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jmux.Http;

import java.io.IOException;

public class CreateJob implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String response = "CreateJob";
        Http.sendResponse(exchange, 200, response.getBytes());
    }

}
