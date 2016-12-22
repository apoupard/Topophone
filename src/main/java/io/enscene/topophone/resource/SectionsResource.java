package io.enscene.topophone.resource;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceIdMapper;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.api.HtmlTemplateEngine;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

@Path("sections")
public class SectionsResource {

  private final HtmlTemplateEngine templateEngine;
  private final ResourceIdMapper resourceIdMapper;

  private final Map<String, ? extends ResourceDao<? extends ResourceModel>> daos;

  @Inject
  SectionsResource(HtmlTemplateEngine templateEngine, ResourceIdMapper resourceIdMapper,
      Map<String, ResourceDao<? extends ResourceModel>> daos) {
    this.templateEngine = templateEngine;
    this.resourceIdMapper = resourceIdMapper;
    this.daos = daos;
  }

  @GET
  @Path("/{name}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ResourceModel get(@PathParam("name") String name, @PathParam("id") String id,
      @QueryParam("version") String version) throws Exception {
    ResourceDao<? extends ResourceModel> dao = ofNullable(daos.get(name))
        .orElseThrow(() -> new Exception("ResourceDao[" + name + "] not found!"));
    return dao.get(id, ofNullable(version))
        .orElseThrow(() -> new Exception("Resource[" + name + "] not found!"));
  }

  @GET
  @Path("/{name}/{id}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("name") String name, @PathParam("id") String id,
      @QueryParam("version") String version, @QueryParam("template") String template)
          throws Exception {
    ResourceModel res = get(name, id, version);
    return templateEngine.execute(name, ofNullable(template), ImmutableMap.of(name, res));
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public ResourceModel getResourceModels(@PathParam("name") String name,
      @QueryParam("version") String version) throws Exception {
    String resourceId = resourceIdMapper.getResourceId(name)
        .orElseThrow(() -> new Exception("Resource[" + name + "] not found!"));
    return get(name, resourceId, version);
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_HTML)
  public String getResourcesHtml(@PathParam("name") String name,
      @QueryParam("version") String version) throws Exception {
    ResourceModel res = getResourceModels(name, version);
    return templateEngine.execute(name, empty(), ImmutableMap.of(name, res));
  }

  public Map<String, ? extends ResourceDao<? extends ResourceModel>> getDaos() {
    return daos;
  }
}
