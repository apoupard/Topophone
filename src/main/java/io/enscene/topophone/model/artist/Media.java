package io.enscene.topophone.model.artist;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableMedia.class)
@JsonDeserialize(as = ImmutableMedia.class)
public interface Media {

  public static Media of(String id, String href) {
    return ImmutableMedia.builder().id(id).href(href).build();
  }

  String getId();

  String getHref();

}
