package jmux;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;

import static org.mockito.Mockito.*;

class RouterTest {

    private Router r;

    @BeforeEach
    void init() {
        r = new Router();
    }

    @Test
    void shouldHandleSimplePath() throws IOException {
        HttpHandler handler = mock(HttpHandler.class);
        r.handleFunc("/jobs", handler).methods("GET");

        HttpExchange exchange = mock(HttpExchange.class);
        when(exchange.getRequestURI()).thenReturn(URI.create("/jobs"));
        when(exchange.getRequestMethod()).thenReturn("GET");
        r.handle(exchange);

        verify(handler).handle(exchange);
    }
}