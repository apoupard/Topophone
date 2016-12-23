package io.enscene.topophone.model.artist;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableHeadbandCarousel.class)
@JsonDeserialize(as = ImmutableHeadbandCarousel.class)
public interface HeadbandCarousel {

  public static HeadbandCarousel of(List<String> images, String logo) {
    return ImmutableHeadbandCarousel.builder().images(images).logo(logo).build();
  }

  List<String> getImages();

  String getLogo();

}
