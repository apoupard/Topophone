package io.enscene.topophone.resource;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.model.header.Header;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("header")
public class HeaderResource {

  private final ResourceDao<Header> headerDao;
  private final HtmlTemplateEngine htmlTemplateEngine;

  @Inject
  HeaderResource(ResourceDao<Header> headerDao, HtmlTemplateEngine htmlTemplateEngine) {
    this.headerDao = headerDao;
    this.htmlTemplateEngine = htmlTemplateEngine;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Header getHeader(@QueryParam("template") String template,
      @QueryParam("template") String version) throws Exception {
    return headerDao.get("1", empty()).orElseThrow(() -> new Exception("Resource not found!"));
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@QueryParam("template") String template,
      @QueryParam("template") String version) throws Exception {
    Header header = getHeader(template, version);
    return htmlTemplateEngine.execute("header", ofNullable(template),
        ImmutableMap.of("header", header));
  }

}
