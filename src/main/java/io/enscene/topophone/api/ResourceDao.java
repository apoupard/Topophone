package io.enscene.topophone.api;

import java.util.Collection;
import java.util.Optional;

public interface ResourceDao<RESOURCE extends ResourceModel> {

  public Optional<RESOURCE> get(String id, Optional<String> optional);

  public Collection<RESOURCE> getAll(Optional<String> optional);
  
//  public Map<String, ? extends Object> getAllHtmlModel();
//  public Map<String, ? extends Object> getHtmlModel(String id);
  
}
