package io.enscene.topophone.resource;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.model.Education;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("education")
public class EducationResource {

  private final ResourceDao<Education> educationDao;

  @Inject
  EducationResource(EducationDao educationDao) {
    this.educationDao = educationDao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Education getEducation(@PathParam("id") String id) throws Exception {
    return educationDao.get(id, Optional.empty()).orElseThrow(
        () -> new Exception("Education not found"));
  }

}
