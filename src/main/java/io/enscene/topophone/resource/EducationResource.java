package io.enscene.topophone.resource;

import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.model.education.Education;

import java.io.StringWriter;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;


@Path("education")
public class EducationResource {

  private final Configuration freemakerConfig;
  private final EducationDao educationDao;

  @Inject
  EducationResource(Configuration freemakerConfig, EducationDao educationDao) {
    this.freemakerConfig = freemakerConfig;
    this.educationDao = educationDao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Education getEducation(@PathParam("id") String id) throws Exception {
    return educationDao.get(id, Optional.empty()).orElseThrow(() -> new Exception("Education not found"));
  }

  @GET
  @Path("/{id}/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id, @PathParam("template") String template)
      throws Exception {
    Template temp = freemakerConfig.getTemplate("education/" + template + ".html");
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of("education", getEducation(id)), out);
    return out.toString();
  }

}
