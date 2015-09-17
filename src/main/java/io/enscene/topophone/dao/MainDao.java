package io.enscene.topophone.dao;

import java.util.Map;

import javax.inject.Singleton;

import io.enscene.topophone.model.Main;
import io.enscene.topophone.model.Youtube;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Video;

@Singleton
public class MainDao extends AstractHardCoded<Main> {

  @Override
  void init(Map<String, Main> database) {
    database.put("1", new Main(new HeadbandCarousel(getDevArtistsHeadbandImages(), "/images/education/headbandlogo.png"), getEnginedTemplate("main", "description"), new Youtube("31o3xo3Lohg"), new Youtube("l3kcrbm2aNc")));
  }
  
  
  
}
