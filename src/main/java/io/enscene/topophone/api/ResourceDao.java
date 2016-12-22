package io.enscene.topophone.api;

import java.util.Collection;
import java.util.Optional;

public interface ResourceDao<RESOURCE extends ResourceModel> {

  Optional<RESOURCE> get(String id, Optional<String> version);

  Collection<RESOURCE> getAll();
}
