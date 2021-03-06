package io.enscene.topophone.api;

import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;

import com.google.common.collect.ImmutableMap;

public class ResourceIdMapper {

  private final Map<String, String> idMapper = ImmutableMap.<String, String>builder()
      .put("accompanying", "1")
      .put("header", "1")
      .put("index", "1")
      .put("main", "1")
      .put("partners", "all")
      .put("devartists", "appscenic")
      .put("education", "presentation")
      .put("nav", "main")
      .put("footer", "1")
      .put("contacts", "1")
      .build();

  public Optional<String> getResourceId(String resourceName) {
    return ofNullable(idMapper.get(resourceName));
  }

}
