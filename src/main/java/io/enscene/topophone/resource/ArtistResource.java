package io.enscene.topophone.resource;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.model.artist.Artist;
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


@Path("artist")
public class ArtistResource {

  private final HtmlTemplateEngine htmlTemplateEngine;
  private final ResourceDao<Artist> dao;

  @Inject
  ArtistResource(HtmlTemplateEngine htmlTemplateEngine, ResourceDao<Artist> dao) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.dao = dao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Artist get(@PathParam("id") String id) throws Exception {
    return dao.get(id, Optional.empty()).orElseThrow(() -> new Exception("Artist not found!"));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id, @QueryParam("template") String template)
      throws Exception {
    Artist artist = get(id);
    return htmlTemplateEngine.execute("artist", Optional.ofNullable(template),
        ImmutableMap.of("artist", artist));
  }

}
