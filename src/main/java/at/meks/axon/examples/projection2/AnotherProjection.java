package at.meks.axon.examples.projection2;

import at.meks.axon.examples.model.Api;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.axonframework.eventhandling.EventHandler;

@ApplicationScoped
public class AnotherProjection {

    private boolean cardIssuedEventWasHandled = false;

    @EventHandler
    void on(Api.CardIssuedEvent event) {
        Log.infof("handling event %s", event);
        cardIssuedEventWasHandled = true;
    }

}
