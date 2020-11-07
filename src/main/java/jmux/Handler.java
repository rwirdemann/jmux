package jmux;

import com.sun.net.httpserver.HttpHandler;

public class Handler {
    private String path;
    private HttpHandler httpHandler;

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
}
