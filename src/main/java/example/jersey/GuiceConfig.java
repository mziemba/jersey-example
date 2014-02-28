package example.jersey;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import example.jersey.exceptions.BadUriException;
import example.jersey.resources.HelloResource;
import example.jersey.resources.JsonResource;

/**
 * Guice bindings module.
 */
public class GuiceConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                bind(HelloResource.class);
                bind(JsonResource.class);
                bind(BadUriException.class);

                serve("/*").with(GuiceContainer.class);
            }
        });
    }
}
