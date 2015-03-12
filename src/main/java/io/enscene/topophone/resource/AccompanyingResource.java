package io.enscene.topophone.resource;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.model.accompanying.Accompanying;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

@Path("accompanying")
public class AccompanyingResource {

  private static final String ACCOMPANYING = "accompanying";

  private final HtmlTemplateEngine htmlTemplateEngine;
  private final ResourceDao<Accompanying> dao;

  @Inject
  AccompanyingResource(HtmlTemplateEngine htmlTemplateEngine, ResourceDao<Accompanying> dao) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.dao = dao;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Accompanying get() throws Exception {
    return dao.get("1", Optional.empty()).orElseThrow(
        () -> new Exception("Accompanying not found!"));
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtml() throws Exception {
    Accompanying accompanying = get();
    return htmlTemplateEngine.execute(ACCOMPANYING, Optional.empty(),
        ImmutableMap.of(ACCOMPANYING, accompanying));
  }

}
