package io.enscene.topophone.api;

import java.util.Collection;
import java.util.Optional;

public interface ResourceDao<RESOURCE extends ResourceModel> {

  public Optional<RESOURCE> get(String id, Optional<String> version);

  public Collection<RESOURCE> getAll(Optional<String> version);
  
}