package jmux;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    public void listenAndServer(int port, Router r) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        for (Handler h : r.getHandler()) {
            server.createContext(h.getPath(), h);
        }
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
    }
}