package io.enscene.topophone.resource;

import io.enscene.topophone.dao.ArtistDao;
import io.enscene.topophone.model.artist.Artist;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("artist")
public class ArtistResource {

  private final ArtistDao dao;

  @Inject
  ArtistResource(ArtistDao dao) {
    this.dao = dao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Artist get(@PathParam("id") String id) throws Exception {
    return dao.get(id, Optional.empty()).orElseThrow(() -> new Exception("Artist not found!"));
  }

}
