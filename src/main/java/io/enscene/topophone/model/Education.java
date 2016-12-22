package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Song;

import java.util.List;

@AutoValue
public abstract class Education implements ResourceModel {

  public static Education of(String id, String imageLeft, String description, Youtube video, HeadbandCarousel headbandCarousel, Nav subNav, List<Song> songs) {
    return new AutoValue_Education.Builder().id(id).imageLeft(imageLeft).description(description).video(video).headbandCarousel(headbandCarousel).subNav(subNav).songs(songs).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder id(String id);

    public abstract Builder imageLeft(String imageLeft);

    public abstract Builder description(String description);

    public abstract Builder video(Youtube video);

    public abstract Builder headbandCarousel(HeadbandCarousel headbandCarousel);

    public abstract Builder subNav(Nav subNav);

    public abstract Builder songs(List<Song> songs);

    public abstract Education build();
  }

  public abstract String getImageLeft();

  public abstract String getDescription();

  public abstract Youtube getVideo();

  public abstract String getId();

  public abstract HeadbandCarousel getHeadbandCarousel();

  public abstract Nav getSubNav();

  public abstract List<Song> getSongs();

}
