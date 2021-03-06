package sample;

import jmux.Router;
import jmux.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Router r = new Router();
        r.handleFunc("/jobs", new CreateJob()).methods("POST");
        r.handleFunc("/jobs", new GetJobs()).methods("GET");
        r.handleFunc("/jobs/{id}", new GetJob()).methods("GET");
        r.handleFunc("/jobs/{id}", new DeleteJob()).methods("DELETE");
        Server server = new Server();
        server.listenAndServer(8080, r);
        System.out.println("Server started on port 8080...");
    }
}
