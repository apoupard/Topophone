package io.enscene.topophone.dao;

import java.util.Map;

import javax.inject.Singleton;

import io.enscene.topophone.model.Main;
import io.enscene.topophone.model.Youtube;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Singleton
public class MainDao extends AstractHardCoded<Main> {

  @Override
  void init(Map<String, Main> database) {
    database.put("1", new Main(new HeadbandCarousel(getEducationHeadbandImages(), "/images/education/headbandlogo.png"), getEnginedTemplate("main", "description"), new Youtube("l3kcrbm2aNc"), new Youtube("31o3xo3Lohg")));
  }
  
  
  
}
