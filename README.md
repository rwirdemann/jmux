# JMux

JMux implements a Java-based request router and dispatcher inspired by [gorilla/mux](https://github.com/gorilla/mux).

## Example

Start by registering a couple of URLs and its handlers:
```Java
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
```

A handler class needs to implement ```com.sun.net.httpserver.HttpHandler```:

```Java
public class GetJob implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        String response = "CreateJob 1";
        Http.sendResponse(exchange, 200, response.getBytes());
    }
}
```

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)