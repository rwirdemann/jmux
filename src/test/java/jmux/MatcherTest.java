package jmux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatcherTest {

    private Matcher m;

    @BeforeEach
    void init() {
        m = new Matcher();
    }

    @Test
    void shouldMatch() {
        assertTrue(m.matches("/jobs", "/jobs"));
        assertFalse(m.matches("/jobs/1", "/jobs"));
        assertTrue(m.matches("/jobs/1", "/jobs/{id}"));
    }
}