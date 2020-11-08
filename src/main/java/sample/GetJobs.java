package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class GetJobs implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();
        String response = "GetJobs";
        exchange.sendResponseHeaders(200, response.length());
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
