package io.enscene.topophone.resource;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.dao.AccompanyingDao;
import io.enscene.topophone.model.accompanying.Accompanying;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("accompanying")
public class AccompanyingResource {

  private final ResourceDao<Accompanying> dao;

  @Inject
  AccompanyingResource(AccompanyingDao dao) {
    this.dao = dao;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Accompanying get() throws Exception {
    return dao.get("1", Optional.empty()).orElseThrow(
        () -> new Exception("Accompanying not found!"));
  }

}
