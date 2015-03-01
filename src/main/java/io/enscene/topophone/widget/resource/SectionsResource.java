package io.enscene.topophone.widget.resource;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("sections")
public class SectionsResource {

  private final HtmlTemplateEngine templateEngine;
  private final Map<String, ResourceDao<? extends ResourceModel>> daos;

  @Inject
  SectionsResource(HtmlTemplateEngine templateEngine,
      Map<String, ResourceDao<? extends ResourceModel>> daos) {
    this.templateEngine = templateEngine;
    this.daos = daos;
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<? extends ResourceModel> getResourceModels(@PathParam("name") String name,
      @QueryParam("version") String version) throws Exception {
    Collection<? extends ResourceModel> models =
        ofNullable(daos.get(name)).orElseThrow(() -> new Exception("Resource not found!")).getAll(
            ofNullable(version));
    return models;
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_HTML)
  public String getResourcesHtml(@PathParam("name") String name,
      @QueryParam("version") String version) throws Exception {
    Collection<? extends ResourceModel> res = getResourceModels(name, version);
    return templateEngine.execute(name, empty(), res);
  }

  @GET
  @Path("/{name}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ResourceModel get(@PathParam("name") String name, @PathParam("id") String id,
      @QueryParam("version") String version) throws Exception {
    ResourceModel model =
        ofNullable(daos.get(name)).orElseThrow(() -> new Exception("Resource not found!"))
            .get(id, ofNullable(version))
            .orElseThrow(() -> new Exception(name + "[" + id + "] not found!"));
    return model;
  }

  @GET
  @Path("/{name}/{id}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("name") String name, @PathParam("id") String id,
      @QueryParam("version") String version, @QueryParam("template") String template)
      throws Exception {
    ResourceModel res = get(name, id, version);
    return templateEngine.execute(name, ofNullable(template), res);
  }

}
