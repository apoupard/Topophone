package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Youtube {

  private String youtubeId;

  public static Youtube of(String youtubeId) {
    return new AutoValue_Youtube.Builder().youtubeId(youtubeId).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder youtubeId(String youtubeId);

    public abstract Youtube build();
  }

  public String getThumbnail() {
    return new StringBuilder().append("https://i.ytimg.com/vi/").append(youtubeId).append("/hqdefault.jpg").toString();
  }

  public String getYoutubeVideo() {
    return new StringBuilder().append("http://www.youtube.com/v/").append(youtubeId).toString();
  }

  public abstract String getYoutubeId();

}
