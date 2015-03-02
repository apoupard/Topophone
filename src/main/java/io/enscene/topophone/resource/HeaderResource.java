package io.enscene.topophone.resource;

import freemarker.template.TemplateException;
import io.enscene.topophone.dao.HeaderDao;
import io.enscene.topophone.model.header.Header;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import static java.util.Optional.ofNullable;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("header")
public class HeaderResource {

  private final HeaderDao headerDao;
  private final HtmlTemplateEngine htmlTemplateEngine;

  @Inject
  HeaderResource(HeaderDao headerDao, HtmlTemplateEngine htmlTemplateEngine) {
    this.headerDao = headerDao;
    this.htmlTemplateEngine = htmlTemplateEngine;
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Header getHeader(@QueryParam("template") String template, @QueryParam("template") String version) throws IOException, TemplateException {
    return headerDao.get(ofNullable(template));
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@QueryParam("template") String template, @QueryParam("template") String version) throws IOException, TemplateException {
    Header header = getHeader(template, version);
    return htmlTemplateEngine.execute("header", ofNullable(template), ImmutableMap.of("header", header));
  }

}
