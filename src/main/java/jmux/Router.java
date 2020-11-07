package jmux;

import com.sun.net.httpserver.HttpHandler;

import java.util.ArrayList;
import java.util.List;

public class Router {

    private List<Handler> handler;

    public Router() {
        this.handler = new ArrayList<>();
    }

    public void handleFunc(String path, HttpHandler httpHandler) {
        this.handler.add(new Handler(path, httpHandler));
    }

    public List<Handler> getHandler() {
        return handler;
    }
}
