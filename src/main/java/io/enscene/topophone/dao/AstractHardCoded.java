package io.enscene.topophone.dao;

import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;

import java.util.Map;
import java.util.Optional;

import com.google.common.collect.Maps;

public abstract class AstractHardCoded<T extends ResourceModel > implements ResourceDao<T> {

  final Map<String, T> database;
  
  public AstractHardCoded() {
    this.database = Maps.newHashMap();
    init(database);
  }

  abstract void init(Map<String, T> database);

  @Override
  public Optional<T> get(String id, Optional<String> version) {
    return Optional.ofNullable(database.get(id));
  }
  
}
