package io.enscene.topophone.widget.resource;

import io.enscene.topophone.widget.model.nav.Entry;
import io.enscene.topophone.widget.model.nav.Nav;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableList;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("nav")
public class NavResource {

  private final Configuration freemakerConfig;

  @Inject
  NavResource(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Nav getMenu() throws IOException, TemplateException {
    return new Nav(entries());
  }
  
  private List<Entry> entries() {
    return ImmutableList.<Entry>builder()
        .add(Entry.of("accompanying", "accompagnement", "/accompanying"))
        .add(educationSubMenu())
        .add(Entry.separator())
        .add(artist())
        .add(Entry.of("partners", "partenaires", "/partners"))       
        .build();
  }

  private Entry artist() {
    return Entry.of("artist", "Artistes", "/artist", ImmutableList.of(
        Entry.of("lecommondiamond", "le common diamond", "/artist/lecommondiamond"),
        Entry.of("internationalhyperrythmique", "international hyper rythmique", "/artist/internationalhyperrythmique")
      ));
  }

  private Entry educationSubMenu() {
    return Entry.of( "education", "Actions éducative", "/education", ImmutableList.of(
        Entry.of("creation", "Création musicale", "/education/creation"),
        Entry.of("initiation", "Initiation à l'écoute", "/education/initiation"),
        Entry.of("meeting", "Rencontre d'artistes", "/education/meeting")));
  }
  
  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile() throws IOException, TemplateException {
    Template temp = freemakerConfig.getTemplate("nav/read.html");
    StringWriter out = new StringWriter();
    temp.process(getMenu(), out);
    return out.toString();
  }

}
