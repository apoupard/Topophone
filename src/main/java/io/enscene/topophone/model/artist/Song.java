package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Song {

  public static Song of(String title, String url) {
    return new AutoValue_Song.Builder().title(title).url(url).build();
  }

  public abstract String getTitle();

  public abstract String getUrl();

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder title(String id);

    public abstract Builder url(String href);

    public abstract Song build();

  }

}
