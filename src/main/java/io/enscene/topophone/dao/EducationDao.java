package io.enscene.topophone.dao;

import io.enscene.topophone.model.Education;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

@Singleton
public class EducationDao extends AstractHardCoded<Education> {

  @Override
  void init(Map<String, Education> database) {
    database.put("creation", new Education("creation", "/images/education/educationImageLeft.png",
        getDescription("education", "creation"), "/images/education/creation.png", getHeadBand(), getSubNav("creation"), getSongs()));
    database.put("meeting", new Education("meeting", "/images/education/educationImageLeft.png",
        getDescription("education", "meeting"), "/images/education/meeting.png", getHeadBand(), getSubNav("meeting"), getSongs()));
    database.put("presentation",
        new Education("presentation", "/images/education/educationImageLeft.png",
            getDescription("education", "presentation"), "/images/education/meeting.png",
            getHeadBand(), getSubNav("presentation"), getSongs()));
  }

  private List<Song> getSongs() {
    List<Song> songs = new ArrayList<>();
    
    songs.add(new Song("Chant du pingouin", "music/education/chantdupingouin.mp3"));
    songs.add(new Song("Grain de folie", "music/education/graindefolie.mp3"));
    songs.add(new Song("Mix au revoir Paris", "music/education/mixaurevoirparis.wav"));
    
    return songs;
  }
  
  private HeadbandCarousel getHeadBand() {
    return new HeadbandCarousel(getImages(), "/images/education/headbandlogo.png");
  }
  
  private Nav getSubNav(String id) {
    List<NavEntry> entries = ImmutableList.of(
          NavEntry.of(id, "Initiation à la création musicale", "/education/creation", "/education/creation".contains(id)),
          NavEntry.of(id, "A la rencontre des artistes", "/education/meeting", "/education/meeting".contains(id))
        );
    return new Nav(entries);
  }

  private List<String> getImages() {
    return ImmutableList.<String>builder().add("images/headbandCarousel/education/01.jpg")
        .add("images/headbandCarousel/education/02.jpg")
        .add("images/headbandCarousel/education/03.jpg")
        .add("images/headbandCarousel/education/04.jpg")
        .add("images/headbandCarousel/education/05.jpg")
        .add("images/headbandCarousel/education/06.jpg")
        .add("images/headbandCarousel/education/07.jpg")
        .add("images/headbandCarousel/education/08.jpg")
        .add("images/headbandCarousel/education/09.jpg")
        .add("images/headbandCarousel/education/10.jpg")
        .add("images/headbandCarousel/education/11.jpg")
        .add("images/headbandCarousel/education/12.jpg")
        .add("images/headbandCarousel/education/13.jpg")
        .add("images/headbandCarousel/education/14.jpg")
        .add("images/headbandCarousel/education/15.jpg")
        .add("images/headbandCarousel/education/16.jpg")
        .add("images/headbandCarousel/education/17.jpg")
        .add("images/headbandCarousel/education/18.jpg")
        .add("images/headbandCarousel/education/19.jpg")
        .add("images/headbandCarousel/education/20.jpg")
        .add("images/headbandCarousel/education/21.jpg")
        .add("images/headbandCarousel/education/22.jpg")
        .build();
  }
}
