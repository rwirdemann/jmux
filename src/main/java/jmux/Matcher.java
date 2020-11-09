package jmux;

public class Matcher {

    public boolean matches(String uri, String route) {
        // /jobs/{id} => /jobs/(.+)
        String p = route.replaceAll("\\{(.+)}", "(.+)");

        return uri.matches(p);
    }
}
