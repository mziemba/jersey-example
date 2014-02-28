package example.jersey;

import com.google.inject.servlet.GuiceFilter;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Main application class.
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    private static Server server;

    public static void main(String[] args) throws Exception {

        log.info("starting server on port: 8090");
        server = new Server(8090);
        final ServletContextHandler sch = new ServletContextHandler(server, "/");
        sch.addEventListener(new GuiceConfig());

        sch.addFilter(GuiceFilter.class, "/*", null);

        sch.addServlet(DefaultServlet.class, "/");

        server.start();
        server.join();
    }
}
