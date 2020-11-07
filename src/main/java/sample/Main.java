package sample;

import jmux.Router;
import jmux.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Router r = new Router();
        r.handleFunc("/jobs", new CreateJob());
        Server server = new Server();
        server.listenAndServer(8080, r);
        System.out.println("Server started on port 8080...");
    }
}
