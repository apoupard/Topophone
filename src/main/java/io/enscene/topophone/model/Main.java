package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@AutoValue
public abstract class Main implements ResourceModel {

  public static Main of(HeadbandCarousel headband, String description, Youtube videoLeft, Youtube videoRight) {
    return new AutoValue_Main.Builder().headbandCarousel(headband).description(description).videoLeft(videoLeft).videoRight(videoRight).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder headbandCarousel(HeadbandCarousel headband);

    public abstract Builder videoLeft(Youtube videoLeft);

    public abstract Builder videoRight(Youtube videoRight);

    public abstract Builder description(String description);

    public abstract Main build();
  }

  public abstract HeadbandCarousel getHeadbandCarousel();

  public abstract String getDescription();

  public abstract Youtube getVideoLeft();

  public abstract Youtube getVideoRight();
  
}
