package jmux;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Router implements HttpHandler {

    private List<Handler> handler;

    public Router() {
        this.handler = new ArrayList<>();
    }

    public Handler handleFunc(String path, HttpHandler httpHandler) {
        Handler h = new Handler(path, httpHandler);
        this.handler.add(h);
        return h;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String uri = exchange.getRequestURI().toString();
        Handler h = getHandler(uri, exchange.getRequestMethod());
        if (h != null) {
            h.handle(exchange);
        } else {
            OutputStream outputStream = exchange.getResponseBody();
            exchange.sendResponseHeaders(getHttpStatus(uri), 0);
            outputStream.flush();
            outputStream.close();
        }
    }

    private int getHttpStatus(String uri) {
        for (Handler h : handler) {
            if (h.getPath().equals(uri)) {
                return 405;
            }
        }
        return 404;
    }

    private Handler getHandler(String uri, String method) {
        for (Handler h : handler) {
            if (h.getPath().equals(uri) && h.getMethods().contains(method)) {
                return h;
            }
        }
        return null;
    }
}
