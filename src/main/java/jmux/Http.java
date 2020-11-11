package jmux;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Http {
    public static void sendResponse(HttpExchange exchange, int statusCode, byte[] response) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();
        exchange.sendResponseHeaders(statusCode, response.length);
        outputStream.write(response);
        outputStream.flush();
        outputStream.close();
    }
}
