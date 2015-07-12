package io.enscene.topophone.dao;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import freemarker.template.TemplateException;

public abstract class AstractHardCoded<T extends ResourceModel > implements ResourceDao<T> {

  final Map<String, T> database = Maps.newHashMap();
  
  private HtmlTemplateEngine engine;
  
  @Inject
  void injectinit(HtmlTemplateEngine engine){
    this.engine = engine;
    init(database);
  }
  
  abstract void init(Map<String, T> database);

  @Override
  public Optional<T> get(String id, Optional<String> version) {
    return Optional.ofNullable(database.get(id));
  }
  
  protected String getDescription(String objectName, String id) {
    try {
      return engine.execute(objectName+"/"+id, Optional.of("description"), ImmutableMap.of());
    } catch (IOException | TemplateException e) {
      e.printStackTrace();
      return "";
    }
  }
  
}
