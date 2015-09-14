package io.enscene.topophone.dao;

import java.util.Map;

import javax.inject.Singleton;

import io.enscene.topophone.model.Main;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Singleton
public class MainDao extends AstractHardCoded<Main> {

  @Override
  void init(Map<String, Main> database) {
    database.put("1", new Main(new HeadbandCarousel(getDevArtistsHeadbandImages(), "/images/education/headbandlogo.png"), getEnginedTemplate("main", "description")));
  }
  
}
