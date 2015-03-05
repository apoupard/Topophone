package io.enscene.topophone.resource;

import static java.util.Optional.ofNullable;
import io.enscene.topophone.dao.PartnersDao;
import io.enscene.topophone.model.partner.Partners;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("partners")
public class PartnerResource {

  private final PartnersDao partnerDao;

  private final HtmlTemplateEngine htmlTemplateEngine;

  @Inject
  PartnerResource(PartnersDao partnerDao, HtmlTemplateEngine htmlTemplateEngine) {
    this.partnerDao = partnerDao;
    this.htmlTemplateEngine = htmlTemplateEngine;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Partners getPartners() throws Exception {
    return partnerDao.get("1", Optional.empty()).orElseThrow(() -> new Exception("Resource not found"));
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@QueryParam("template") String template) throws Exception {
    Partners entry = getPartners();
    return htmlTemplateEngine.execute("partners", ofNullable(template), ImmutableMap.of("partners", entry));
  }

}
