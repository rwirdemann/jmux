package jmux;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Handler implements HttpHandler {
    private final String path;
    private final HttpHandler httpHandler;
    private List<String> methods;

    public Handler(String path, HttpHandler httpHandler) {
        this.path = path;
        this.httpHandler = httpHandler;
    }

    public void methods(String... methods) {
        this.methods = Arrays.asList(methods);
    }

    public List<String> getMethods() {
        return methods;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        httpHandler.handle(exchange);
    }
}
