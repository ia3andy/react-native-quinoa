package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Type;

import java.util.List;

@Path("/beers")
public class BeerResource {

    @GET
    @Path("types")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Type>> types() {
        return Type.<Type>listAll();
    }

}
