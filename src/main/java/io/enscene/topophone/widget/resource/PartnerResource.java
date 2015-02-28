package io.enscene.topophone.widget.resource;

import static com.google.common.collect.Multimaps.index;
import io.enscene.topophone.widget.dao.PartnerDao;
import io.enscene.topophone.widget.model.partner.Partner;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("partners")
public class PartnerResource {

  private final Configuration freemakerConfig;

  private final PartnerDao partnerDao;

  @Inject
  PartnerResource(Configuration freemakerConfig, PartnerDao partnerDao) {
    this.freemakerConfig = freemakerConfig;
    this.partnerDao = partnerDao;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Collection<Partner>> getPartners() throws IOException, TemplateException {
    return index(partnerDao.getAll(), (partner) -> {
      return partner.getType();
    }).asMap();

  }

  @GET
  @Path("/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("template") String template) throws IOException,
      TemplateException {
    Template temp = freemakerConfig.getTemplate("partner/" + template + ".html");
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of("partners", getPartners()), out);
    // return Processor.process(out.toString());
    return out.toString();
  }

}
