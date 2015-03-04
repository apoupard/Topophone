package io.enscene.topophone.resource;

import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.model.education.Education;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

@Path("education")
public class EducationResource {

  private final HtmlTemplateEngine htmlTemplateEngine;
  private final EducationDao educationDao;

  @Inject
  EducationResource(HtmlTemplateEngine htmlTemplateEngine, EducationDao educationDao) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.educationDao = educationDao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Education getEducation(@PathParam("id") String id) throws Exception {
    return educationDao.get(id, Optional.empty()).orElseThrow(() -> new Exception("Education not found"));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id, @QueryParam("template") String template)
      throws Exception {
    Education education = getEducation(id);
    return htmlTemplateEngine.execute("education", Optional.ofNullable(template), ImmutableMap.of("education", education));
  }

}
