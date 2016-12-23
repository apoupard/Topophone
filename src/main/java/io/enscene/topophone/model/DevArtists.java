package io.enscene.topophone.model;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Value.Immutable
@JsonSerialize(as = ImmutableDevArtists.class)
@JsonDeserialize(as = ImmutableDevArtists.class)
public interface DevArtists extends ResourceModel {

  public static DevArtists of(String id, String description, String image, HeadbandCarousel headbandCarousel, Nav subNav, String blockRight, List<ArtistLink> artistLinks) {
    return ImmutableDevArtists.builder().id(id).description(description).image(image).headbandCarousel(headbandCarousel).subNav(subNav).blockRight(blockRight).artistLinks(artistLinks).build();
  }

  public static DevArtists of(String id, String description, String image, HeadbandCarousel headbandCarousel, Nav subNav, String blockRight, String imageLeft) {
    return ImmutableDevArtists.builder().id(id).description(description).image(image).headbandCarousel(headbandCarousel).subNav(subNav).blockRight(blockRight).artistLinks(ImmutableList.of()).imageLeft(imageLeft).build();
  }

  String getDescription();

  String getImage();

  String getId();

  HeadbandCarousel getHeadbandCarousel();

  Nav getSubNav();

  @Nullable
  String getImageLeft();

  String getBlockRight();

  List<ArtistLink> getArtistLinks();

  @Value.Immutable
  @JsonSerialize(as = ImmutableArtistLink.class)
  @JsonDeserialize(as = ImmutableArtistLink.class)
  static public interface  ArtistLink {

    public static ArtistLink of(String image, String link) {
      return ImmutableArtistLink.builder().image(image).link(link).build();
    }

    String getImage();

    String getLink();

  }
}
