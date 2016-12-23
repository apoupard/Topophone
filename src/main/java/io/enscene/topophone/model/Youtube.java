package io.enscene.topophone.model;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableYoutube.class)
@JsonDeserialize(as = ImmutableYoutube.class)
public interface Youtube {

  public static Youtube of(String youtubeId) {
    return ImmutableYoutube.builder().youtubeId(youtubeId).build();
  }

  @Value.Default
  public default String getThumbnail() {
    return new StringBuilder().append("https://i.ytimg.com/vi/").append(getYoutubeId()).append("/hqdefault.jpg").toString();
  }

  @Value.Default
  public default String getYoutubeVideo() {
    return new StringBuilder().append("http://www.youtube.com/v/").append(getYoutubeId()).toString();
  }

  String getYoutubeId();

}
