package at.meks.axon.examples.projection;

import at.meks.axon.examples.model.Api;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.axonframework.eventhandling.EventHandler;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GiftcardInMemoryHistory {

    private final List<Object> history = new ArrayList<>();

    @EventHandler
    void handle(Api.CardIssuedEvent event) {
        Log.infof("handling event %s", event);
        history.add(event);
    }

    @EventHandler
    void handle(Api.CardRedeemedEvent event) {
        Log.infof("handling event %s", event);
        history.add(event);
    }

}
