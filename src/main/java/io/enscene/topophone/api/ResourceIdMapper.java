package io.enscene.topophone.api;

import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;

import com.google.common.collect.ImmutableMap;

public class ResourceIdMapper {
  
  private final Map<String, String> idMapper = ImmutableMap.of(
      "accompanying", "1",
      "header", "1",
      "main", "1",
      "partners", "1",
      "nav", "1"
      );
  
  public Optional<String> getResourceId(String resourceName) {
    return ofNullable(idMapper.get(resourceName));
  }

}
