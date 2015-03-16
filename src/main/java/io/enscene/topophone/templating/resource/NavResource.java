package io.enscene.topophone.templating.resource;

import static java.util.Optional.empty;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceIdMapper;
import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("nav")
public class NavResource {

  private final HtmlTemplateEngine htmlTemplateEngine;
  private final ResourceDao<Nav> dao;
  private final ResourceIdMapper resourceIdMapper;

  @Inject
  NavResource(HtmlTemplateEngine htmlTemplateEngine, NavDao dao, ResourceIdMapper resourceIdMapper) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.dao = dao;
    this.resourceIdMapper = resourceIdMapper;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Nav getMenu() throws Exception {
    String id = resourceIdMapper.getResourceId("nav").orElseThrow(() -> new Exception("[nav] Default resource id not found"));
    return dao.get(id, Optional.empty()).orElseThrow(() -> new Exception("[nav] Default resource id not found"));
  }

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile() throws Exception {
    Nav nav = getMenu();
    return htmlTemplateEngine.execute("nav", empty(), ImmutableMap.of("nav", nav));
  }

}
