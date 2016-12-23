package io.enscene.topophone.model.artist;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableVideo.class)
@JsonDeserialize(as = ImmutableVideo.class)
public interface Video {

  public static Video of(String youtubeId, String title, String date, String mix, String production) {
    return ImmutableVideo.builder().youtubeId(youtubeId).title(title).date(date).mix(mix).production(production).build();
  }

  String getYoutubeId();

  String getTitle();

  String getDate();

  String getMix();

  String getProduction();
  
  @Value.Default
  public default String getThumbnail() {
    return new StringBuilder().append("https://i.ytimg.com/vi/").append(getYoutubeId()).append("/hqdefault.jpg").toString();
  }

  @Value.Default
  public default String getYoutubeVideo() {
    return new StringBuilder().append("http://www.youtube.com/v/").append(getYoutubeId()).toString();
  }

}
