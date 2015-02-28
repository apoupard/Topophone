package io.enscene.topophone.api;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface ResourceDao<RESOURCE extends ResourceModel> {

  public Optional<RESOURCE> get(String id);

  public Collection<RESOURCE> getAll();
  
  public Map<String, ? extends Object> getAllHtmlModel();

  public Map<String, ? extends Object> getHtmlModel(String id);
  
}
