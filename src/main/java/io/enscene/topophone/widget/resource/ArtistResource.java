package io.enscene.topophone.widget.resource;

import io.enscene.topophone.widget.dao.ArtistDao;
import io.enscene.topophone.widget.model.artist.Artist;

import java.io.StringWriter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import freemarker.template.Configuration;
import freemarker.template.Template;


@Path("artist")
public class ArtistResource {

  private final Configuration freemakerConfig;
  private final ArtistDao dao;

  @Inject
  ArtistResource(Configuration freemakerConfig, ArtistDao dao) {
    this.freemakerConfig = freemakerConfig;
    this.dao = dao;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Artist getProfile(@PathParam("id") String id) throws Exception {
    return dao.get(id).orElseThrow(() -> new Exception("Artist not found!"));
  }

  @GET
  @Path("/{id}/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id, @PathParam("template") String template)
      throws Exception {
    Template temp = freemakerConfig.getTemplate("artist/" + template + ".html");
    StringWriter out = new StringWriter();
    Artist art = getProfile(id);
    temp.process(art, out);
    // return Processor.process(out.toString());
    return out.toString();
  }

}
