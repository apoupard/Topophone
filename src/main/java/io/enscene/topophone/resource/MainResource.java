package io.enscene.topophone.resource;

import io.enscene.topophone.dao.MainDao;
import io.enscene.topophone.model.main.Main;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

@Path("main")
public class MainResource {

  private final HtmlTemplateEngine htmlTemplateEngine;
  private final MainDao mainDao;

  @Inject
  MainResource(HtmlTemplateEngine htmlTemplateEngine, MainDao mainDao) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.mainDao = mainDao;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Main get() throws Exception {
    return mainDao.get("1", Optional.empty()).orElseThrow(() -> new Exception("Education not found"));
  }

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@QueryParam("template") String template)
      throws Exception {
    Main main = get();
    return htmlTemplateEngine.execute("main", Optional.ofNullable(template), ImmutableMap.of("main", main));
  }

}
