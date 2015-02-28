package io.enscene.topophone.widget.resource;

import static java.util.Optional.ofNullable;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.*;

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

@Path("all")
public class AllResource {

  private final Configuration freemakerConfig;
  private final Map<String, ResourceDao<? extends ResourceModel>> daos;

  @Inject
  AllResource(Configuration freemakerConfig, Map<String, ResourceDao<? extends ResourceModel>> daos) {
    this.freemakerConfig = freemakerConfig;
    this.daos = daos;
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<? extends ResourceModel> getResourceModels(@PathParam("name") String name)
      throws Exception {
    return ofNullable(daos.get(name)).orElseThrow(() -> new Exception("Resource not found!"))
        .getAll();
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_HTML)
  public String getResourcesHtml(@PathParam("name") String name) throws Exception {
    Collection<? extends ResourceModel> res = getResourceModels(name);
    return engineTemplate(name, empty(), res);
  }

  @GET
  @Path("/{name}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ResourceModel get(@PathParam("name") String name, @PathParam("id") String id)
      throws Exception {
    return ofNullable(daos.get(name)).orElseThrow(() -> new Exception("Resource not found!"))
        .get(id).orElseThrow(() -> new Exception(name + "[" + id + "] not found!"));
  }

  @GET
  @Path("/{name}/{id}/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("name") String name, @PathParam("id") String id,
      @PathParam("template") String template) throws Exception {
    ResourceModel res = get(name, id);
    return engineTemplate(name, of(template), res);
  }

  private String engineTemplate(String name, Optional<String> template, Object res)
      throws IOException, TemplateException {
    StringBuilder templateName =
        new StringBuilder().append(name).append("/").append(template.orElse("section"))
            .append(".html");


    Template temp = freemakerConfig.getTemplate(templateName.toString());
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of(name, res), out);
    // return Processor.process(out.toString());
    return out.toString();
  }

}
