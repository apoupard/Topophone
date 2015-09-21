package io.enscene.topophone.dao;

import io.enscene.topophone.model.Education;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;
import io.enscene.topophone.model.Youtube;
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
        getDescription("education", "creation"), getVideo(), getHeadBand(), getSubNav("creation"), getSongs()));
    database.put("meeting", new Education("meeting", "/images/education/educationImageLeft.png",
        getDescription("education", "meeting"), getVideo(), getHeadBand(), getSubNav("meeting"), getSongs()));
    database.put("presentation",
        new Education("presentation", "/images/education/educationImageLeft.png",
            getDescription("education", "presentation"), getVideo(),
            getHeadBand(), getSubNav("presentation"), getSongs()));
  }
  
  private Youtube getVideo(){
    return new Youtube("31o3xo3Lohg");
  }

  private List<Song> getSongs() {
    List<Song> songs = new ArrayList<>();
    
    songs.add(new Song("Chant du pingouin", "music/education/chantdupingouin.mp3"));
    songs.add(new Song("Grain de folie", "music/education/graindefolie.mp3"));
    songs.add(new Song("Mix au revoir Paris", "music/education/mixaurevoirparis.wav"));
    
    return songs;
  }
  
  private HeadbandCarousel getHeadBand() {
    return new HeadbandCarousel(getEducationHeadbandImages(), "/images/education/headbandlogo.png");
  }
  
  private Nav getSubNav(String id) {
    List<NavEntry> entries = ImmutableList.of(
          NavEntry.of(id, "Initiation à la création musicale", "/education/creation", "/education/creation".contains(id)),
          NavEntry.of(id, "A la rencontre des artistes", "/education/meeting", "/education/meeting".contains(id))
        );
    return new Nav(entries);
  }

}
