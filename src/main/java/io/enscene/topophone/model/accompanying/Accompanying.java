package io.enscene.topophone.model.accompanying;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import java.util.Collection;

@AutoValue
public abstract class Accompanying implements ResourceModel {

  public static Accompanying of(HeadbandCarousel headband, Collection<String> objectives, Contact contact, String description, String picture) {
    return new AutoValue_Accompanying.Builder().headbandCarousel(headband).objectives(objectives).contact(contact).description(description).picture(picture).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder headbandCarousel(HeadbandCarousel headbandCarousel);

    public abstract Builder objectives(Collection<String> objectives);

    public abstract Builder contact(Contact contact);

    public abstract Builder description(String description);

    public abstract Builder picture(String picture);

    public abstract Accompanying build();

  }

  public abstract HeadbandCarousel getHeadbandCarousel();

  public abstract Collection<String> getObjectives();

  public abstract Contact getContact();

  public abstract String getDescription();

  public abstract String getPicture();

}
