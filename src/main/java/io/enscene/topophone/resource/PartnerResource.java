package io.enscene.topophone.resource;

import static java.util.Optional.ofNullable;
import freemarker.template.TemplateException;
import io.enscene.topophone.dao.PartnerDao;
import io.enscene.topophone.model.partner.Partner;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import java.util.Collection;
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

  private final PartnerDao partnerDao;

  private final HtmlTemplateEngine htmlTemplateEngine;

  @Inject
  PartnerResource(PartnerDao partnerDao, HtmlTemplateEngine htmlTemplateEngine) {
    this.partnerDao = partnerDao;
    this.htmlTemplateEngine = htmlTemplateEngine;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<Partner> getPartners() throws IOException, TemplateException {
    return partnerDao.getAll(Optional.empty());
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@QueryParam("template") String template) throws IOException,
      TemplateException {
    Collection<Partner> entry = getPartners();
    return htmlTemplateEngine.execute("partners", ofNullable(template), ImmutableMap.of("partners", entry));
  }

}
