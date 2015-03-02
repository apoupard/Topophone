package io.enscene.topophone.resource;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import freemarker.template.TemplateException;
import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.model.nav.Entry;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("nav")
public class NavResource {

  private HtmlTemplateEngine htmlTemplateEngine;
  private  NavDao dao;

  @Inject
  NavResource(HtmlTemplateEngine htmlTemplateEngine, NavDao dao) {
    this.htmlTemplateEngine = htmlTemplateEngine;
    this.dao = dao;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<Entry> getMenu() throws IOException, TemplateException {
    return dao.getAll(empty());
  }

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile() throws IOException, TemplateException {
    Collection<Entry> nav = getMenu();
    return htmlTemplateEngine.execute("nav", empty(), ImmutableMap.of("nav", nav));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  private Entry getSubMenu(String id) throws Exception {
    return dao.get(id, empty()).orElseThrow(() -> new Exception("Entry not found"));
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id) throws Exception {
    Entry entry = getSubMenu(id);
    return htmlTemplateEngine.execute("nav", of("subsection"), ImmutableMap.of("entry", entry));
  }
  
}
