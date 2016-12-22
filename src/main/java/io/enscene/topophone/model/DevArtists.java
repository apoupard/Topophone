package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import javax.annotation.Nullable;
import java.util.List;

@AutoValue
public abstract class DevArtists implements ResourceModel {

  public static DevArtists of(String id, String description, String image, HeadbandCarousel headbandCarousel, Nav subNav, String blockRight, List<ArtistLink> artistLinks) {
    return new AutoValue_DevArtists.Builder().id(id).description(description).image(image).headbandCarousel(headbandCarousel).subNav(subNav).blockRight(blockRight).artistLinks(artistLinks).build();
  }

  public static DevArtists of(String id, String description, String image, HeadbandCarousel headbandCarousel, Nav subNav, String blockRight, String imageLeft) {
    return new AutoValue_DevArtists.Builder().id(id).description(description).image(image).headbandCarousel(headbandCarousel).subNav(subNav).blockRight(blockRight).artistLinks(ImmutableList.of()).imageLeft(imageLeft).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder id(String id);

    public abstract Builder description(String description);

    public abstract Builder image(String image);

    public abstract Builder headbandCarousel(HeadbandCarousel headband);

    public abstract Builder artistLinks(List<ArtistLink> artistLinks);

    public abstract Builder imageLeft(String imageLeft);

    public abstract Builder subNav(Nav subNav);

    public abstract Builder blockRight(String blockRight);

    public abstract DevArtists build();
  }

  public abstract String getDescription();

  public abstract String getImage();

  public abstract String getId();

  public abstract HeadbandCarousel getHeadbandCarousel();

  public abstract Nav getSubNav();

  @Nullable
  public abstract String getImageLeft();

  public abstract String getBlockRight();

  public abstract List<ArtistLink> getArtistLinks();

  @AutoValue
  public abstract static class ArtistLink {

    public static ArtistLink of(String image, String link) {
      return new AutoValue_DevArtists_ArtistLink.Builder().image(image).link(link).build();
    }

    @AutoValue.Builder
    public abstract static class Builder {
      public abstract Builder image(String image);

      public abstract Builder link(String link);

      public abstract ArtistLink build();
    }

    public abstract String getImage();

    public abstract String getLink();

  }
}
