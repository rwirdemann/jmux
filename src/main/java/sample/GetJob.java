package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jmux.Http;

import java.io.IOException;
import java.io.OutputStream;

public class GetJob implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String response = "CreateJob 1";
        Http.sendResponse(exchange, 200, response.getBytes());
    }
}
