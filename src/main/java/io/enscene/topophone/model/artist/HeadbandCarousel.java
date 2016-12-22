package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class HeadbandCarousel {

  public static HeadbandCarousel of(List<String> images, String logo) {
    return new AutoValue_HeadbandCarousel.Builder().images(images).logo(logo).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder images(List<String> images);

    public abstract Builder logo(String logo);

    public abstract HeadbandCarousel build();

  }

  public abstract List<String> getImages();

  public abstract String getLogo();

}
