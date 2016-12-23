package io.enscene.topophone.model.artist;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableSong.class)
@JsonDeserialize(as = ImmutableSong.class)
public interface Song {

  public static Song of(String title, String url) {
    return ImmutableSong.builder().title(title).url(url).build();
  }

  String getTitle();

  String getUrl();
}
