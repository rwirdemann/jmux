package jmux;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Handler implements HttpHandler {
    private String path;
    private HttpHandler httpHandler;
    private List<String> methods;


    public Handler(String path, HttpHandler httpHandler) {
        this.path = path;
        this.httpHandler = httpHandler;
    }

    public String getPath() {
        return path;
    }

    public HttpHandler getHttpHandler() {
        return httpHandler;
    }

    public void methods(String... methods) {
        this.methods = Arrays.asList(methods);
    }

    public List<String> getMethods() {
        return methods;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (methods.contains(exchange.getRequestMethod())) {
            httpHandler.handle(exchange);
        } else {
            OutputStream outputStream = exchange.getResponseBody();
            exchange.sendResponseHeaders(405, 0);
            outputStream.flush();
            outputStream.close();
        }
    }
}
