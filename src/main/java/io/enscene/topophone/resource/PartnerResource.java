package io.enscene.topophone.resource;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.dao.PartnersDao;
import io.enscene.topophone.model.partner.Partners;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("partners")
public class PartnerResource {

  private final ResourceDao<Partners> partnerDao;

  @Inject
  PartnerResource(PartnersDao partnerDao) {
    this.partnerDao = partnerDao;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Partners getPartners() throws Exception {
    return partnerDao.get("1", Optional.empty()).orElseThrow(
        () -> new Exception("Resource not found"));
  }

}
