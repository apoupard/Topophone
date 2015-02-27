package io.enscene.topophone.widget.resource;

import java.io.IOException;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("index")
public class IndexResource {

  private final Configuration freemakerConfig;

  @Inject
  IndexResource(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlIndex() throws IOException, TemplateException {
    Template temp = freemakerConfig.getTemplate("index.html");
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of(), out);
    return out.toString();
  }

}
