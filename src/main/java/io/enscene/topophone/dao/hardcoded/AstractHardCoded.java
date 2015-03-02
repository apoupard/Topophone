package io.enscene.topophone.dao.hardcoded;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.google.common.collect.Maps;

public abstract class AstractHardCoded<T> {

  final Map<String, T> database;
  
  public AstractHardCoded() {
    this.database = Maps.newHashMap();
    init(database);
  }

  abstract void init(Map<String, T> database);
  
  public Optional<T> get(String id, Optional<String> version) {
    return Optional.ofNullable(database.get(id));
  }
  
  public Collection<T> getAll(Optional<String> version) {
    return database.values();
  }
  
}
