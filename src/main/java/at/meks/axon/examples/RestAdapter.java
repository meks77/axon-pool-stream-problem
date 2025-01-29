package at.meks.axon.examples;

import at.meks.axon.examples.model.Api;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.UUID;

@Path("/card")
public class RestAdapter {

    @Inject
    CommandGateway commandGateway;

    @POST
    public Uni<String> issueCard(@RestQuery int initialAmount) {
        String cardId = UUID.randomUUID().toString();

        return Uni.createFrom()
                  .future(commandGateway.send(new Api.IssueCardCommand(cardId, initialAmount)));
    }
}
