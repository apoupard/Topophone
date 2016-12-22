package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Video {

  public static Video of(String youtubeId, String title, String date, String mix, String production) {
    return new AutoValue_Video.Builder().youtubeId(youtubeId).title(title).date(date).mix(mix).production(production).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder youtubeId(String youtubeId);

    public abstract Builder title(String title);

    public abstract Builder date(String date);

    public abstract Builder mix(String mix);

    public abstract Builder production(String production);

    public abstract Video build();

  }

  public abstract String getYoutubeId();

  public abstract String getTitle();

  public abstract String getDate();

  public abstract String getMix();

  public abstract String getProduction();

  public String getThumbnail() {
    return new StringBuilder().append("https://i.ytimg.com/vi/").append(getYoutubeId()).append("/hqdefault.jpg").toString();
  }

  public String getYoutubeVideo() {
    return new StringBuilder().append("http://www.youtube.com/v/").append(getYoutubeId()).toString();
  }

}
