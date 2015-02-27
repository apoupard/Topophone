package io.enscene.topophone.widget.resource;

import java.io.IOException;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("header")
public class HeaderResource {

  private final Configuration freemakerConfig;

  @Inject
  HeaderResource(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile() throws IOException, TemplateException {
    Template temp = freemakerConfig.getTemplate("header/read.html");
    StringWriter out = new StringWriter();
    temp.process(null, out);
    return out.toString();
  }
  
}
