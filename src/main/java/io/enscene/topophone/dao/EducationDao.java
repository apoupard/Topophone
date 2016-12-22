package io.enscene.topophone.dao;

import com.google.common.collect.ImmutableList;
import io.enscene.topophone.model.Education;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;
import io.enscene.topophone.model.Youtube;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Song;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Singleton
public class EducationDao extends AstractHardCoded<Education> {

  @Override
  void init(Map<String, Education> database) {
    database.put("creation", Education.of("creation", "/images/education/left/05.jpg",
        getDescription("education", "creation"), getVideo(), getHeadBand(), getSubNav("creation"), getSongs()));
    database.put("meeting", Education.of("meeting", "/images/education/left/03.jpg",
        getDescription("education", "meeting"), getVideo(), getHeadBand(), getSubNav("meeting"), getSongs()));
    database.put("presentation",
        Education.of("presentation", "/images/education/left/01.jpg",
            getDescription("education", "presentation"), getVideo(),
            getHeadBand(), getSubNav("presentation"), getSongs()));
  }
  
  private Youtube getVideo(){
    return Youtube.of("D1QOwfWPUZI");
  }

  private List<Song> getSongs() {
    List<Song> songs = new ArrayList<>();

    songs.add(Song.of("Chant du pingouin", "music/education/chantdupingouin.mp3"));
    songs.add(Song.of("Grain de folie", "music/education/graindefolie.mp3"));
    songs.add(Song.of("Mix au revoir Paris", "music/education/mixaurevoirparis.wav"));
    
    return songs;
  }
  
  private HeadbandCarousel getHeadBand() {
    return HeadbandCarousel.of(getEducationHeadbandImages(), "/images/education/headbandlogo.png");
  }
  
  private Nav getSubNav(String id) {
    List<NavEntry> entries = ImmutableList.of(
          NavEntry.of(id, "Création musicale", "/education/creation", "/education/creation".contains(id)),
          NavEntry.of(id, "L'évenement des apprentis-musiciens", "/education/meeting", "/education/meeting".contains(id))
        );
    return Nav.of(entries);
  }

}
