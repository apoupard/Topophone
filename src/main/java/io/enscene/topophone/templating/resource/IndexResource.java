package io.enscene.topophone.templating.resource;

import static java.util.Optional.empty;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.common.collect.ImmutableMap;

import io.enscene.topophone.templating.HtmlTemplateEngine;

@Path("index")
public class IndexResource {

  private final HtmlTemplateEngine templateEngine;

  @Inject
  IndexResource(HtmlTemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  @GET
  public String get() throws Exception {
    return templateEngine.execute("index", Optional.of("index"), ImmutableMap.of());
  }

}
