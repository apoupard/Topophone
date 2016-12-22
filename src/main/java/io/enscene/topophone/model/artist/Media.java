package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Media {

  public static Media of(String id, String href) {
    return new AutoValue_Media.Builder().id(id).href(href).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder id(String id);

    public abstract Builder href(String href);

    public abstract Media build();

  }

  public abstract String getId();

  public abstract String getHref();

}
