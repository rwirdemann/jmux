package jmux;

import com.sun.net.httpserver.HttpHandler;

import java.util.ArrayList;
import java.util.List;

public class Router {

    private List<Handler> handler;

    public Router() {
        this.handler = new ArrayList<>();
    }

    public Handler handleFunc(String path, HttpHandler httpHandler){
        Handler e = new Handler(path, httpHandler);
        this.handler.add(e);
        return e;
    }

    public List<Handler> getHandler() {
        return handler;
    }
}
