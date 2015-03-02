package io.enscene.topophone.resource;

import freemarker.template.TemplateException;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("index")
public class IndexResource {

  private final HtmlTemplateEngine htmlTemplateEngine;

  @Inject
  IndexResource(HtmlTemplateEngine htmlTemplateEngine) {
    this.htmlTemplateEngine = htmlTemplateEngine;
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlIndex() throws IOException, TemplateException {
    return htmlTemplateEngine.execute("index", Optional.of("index"), ImmutableMap.of());
  }

}
