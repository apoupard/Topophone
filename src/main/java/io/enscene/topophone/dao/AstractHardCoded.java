package io.enscene.topophone.dao;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import freemarker.template.TemplateException;

public abstract class AstractHardCoded<T extends ResourceModel> implements ResourceDao<T> {

  final Map<String, T> database = Maps.newHashMap();

  private HtmlTemplateEngine engine;

  @Inject
  void injectinit(HtmlTemplateEngine engine) {
    this.engine = engine;
    init(database);
  }

  abstract void init(Map<String, T> database);

  @Override
  public Optional<T> get(String id, Optional<String> version) {
    return Optional.ofNullable(database.get(id));
  }

  protected String getDescription(String objectName, String id) {
    return getEnginedTemplate(objectName, "description", id);
  }
  
  protected String getEnginedTemplate(String objectName, String templateName) {
    try {
      return engine.execute(objectName + "/", Optional.of(templateName), ImmutableMap.of());
    } catch (IOException | TemplateException e) {
      e.printStackTrace();
      return "";
    }
  }
  
  protected String getEnginedTemplate(String objectName, String templateName, String id) {
    try {
      return engine.execute(objectName + "/" + id, Optional.of(templateName), ImmutableMap.of());
    } catch (IOException | TemplateException e) {
      e.printStackTrace();
      return "";
    }
  }

  protected List<String> getDevArtistsHeadbandImages() {
    List<String> list = new ArrayList<>();
    list.add("images/headbandCarousel/devartists/01.jpg");
    list.add("images/headbandCarousel/devartists/02.jpg");
    list.add("images/headbandCarousel/devartists/03.jpg");
    list.add("images/headbandCarousel/devartists/04.jpg");
    list.add("images/headbandCarousel/devartists/05.jpg");
    list.add("images/headbandCarousel/devartists/06.jpg");
    list.add("images/headbandCarousel/devartists/07.jpg");
    list.add("images/headbandCarousel/devartists/08.jpg");
    list.add("images/headbandCarousel/devartists/09.jpg");
    list.add("images/headbandCarousel/devartists/10.jpg");
    list.add("images/headbandCarousel/devartists/11.jpg");
    list.add("images/headbandCarousel/devartists/12.jpg");
    list.add("images/headbandCarousel/devartists/13.jpg");
    list.add("images/headbandCarousel/devartists/14.jpg");
    list.add("images/headbandCarousel/devartists/15.jpg");
    list.add("images/headbandCarousel/devartists/16.jpg");
    list.add("images/headbandCarousel/devartists/17.jpg");
    list.add("images/headbandCarousel/devartists/18.jpg");
    list.add("images/headbandCarousel/devartists/19.jpg");
    return list;
  }
  
  protected List<String> getEducationHeadbandImages() {
    return ImmutableList.<String>builder().add("images/headbandCarousel/education/01.jpg")
        .add("images/headbandCarousel/education/02.jpg")
        .add("images/headbandCarousel/education/03.jpg")
        .add("images/headbandCarousel/education/04.jpg")
        .add("images/headbandCarousel/education/05.jpg")
        .add("images/headbandCarousel/education/06.jpg")
        .add("images/headbandCarousel/education/07.jpg")
        .add("images/headbandCarousel/education/08.jpg")
        .add("images/headbandCarousel/education/09.jpg")
        .add("images/headbandCarousel/education/10.jpg")
        .add("images/headbandCarousel/education/11.jpg")
        .add("images/headbandCarousel/education/12.jpg")
        .add("images/headbandCarousel/education/13.jpg")
        .add("images/headbandCarousel/education/14.jpg")
        .add("images/headbandCarousel/education/15.jpg")
        .add("images/headbandCarousel/education/16.jpg")
        .add("images/headbandCarousel/education/17.jpg")
        .add("images/headbandCarousel/education/18.jpg")
        .add("images/headbandCarousel/education/19.jpg")
        .add("images/headbandCarousel/education/20.jpg")
        .add("images/headbandCarousel/education/21.jpg")
        .add("images/headbandCarousel/education/22.jpg")
        .build();
  }

}
