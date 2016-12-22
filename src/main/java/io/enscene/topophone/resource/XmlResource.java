package io.enscene.topophone.resource;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import io.enscene.topophone.api.HtmlTemplateEngine;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceIdMapper;
import io.enscene.topophone.api.ResourceModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

@Path("xml")
public class XmlResource {

  private final HtmlTemplateEngine templateEngine;
  private final ResourceIdMapper resourceIdMapper;
  private final Map<String, ? extends ResourceDao<? extends ResourceModel>> daos;

  @Inject
  XmlResource(HtmlTemplateEngine templateEngine, ResourceIdMapper resourceIdMapper,
              Map<String, ResourceDao<? extends ResourceModel>> daos) {
    this.templateEngine = templateEngine;
    this.resourceIdMapper = resourceIdMapper;
    this.daos = daos;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Ttt> get() throws Exception {
    List<Ttt> ress = Lists.newArrayList();
    ress.add(new Ttt());
//    for (ResourceDao<? extends ResourceModel> dao : daos.values()) {
//      ress.addAll(dao.getAll());
//    }
    return ress;
  }


  public static class Ttt {
  }

}
