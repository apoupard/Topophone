package io.enscene.topophone.model;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Song;

@Value.Immutable
@JsonSerialize(as = ImmutableEducation.class)
@JsonDeserialize(as = ImmutableEducation.class)
public interface Education extends ResourceModel {

  public static Education of(String id, String imageLeft, String description, Youtube video, HeadbandCarousel headbandCarousel, Nav subNav, List<Song> songs) {
    return ImmutableEducation.builder().id(id).imageLeft(imageLeft).description(description).video(video).headbandCarousel(headbandCarousel).subNav(subNav).songs(songs).build();
  }

  String getImageLeft();

  String getDescription();

  Youtube getVideo();

  String getId();

  HeadbandCarousel getHeadbandCarousel();

  Nav getSubNav();

  List<Song> getSongs();

}
