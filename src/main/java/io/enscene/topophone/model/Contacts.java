package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@AutoValue
public abstract class Contacts implements ResourceModel {

  public static Contacts of(HeadbandCarousel headbandCarousel) {
    return new AutoValue_Contacts.Builder().headbandCarousel(headbandCarousel).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder headbandCarousel(HeadbandCarousel headband);

    public abstract Contacts build();
  }

  public abstract HeadbandCarousel getHeadbandCarousel();
  
}
