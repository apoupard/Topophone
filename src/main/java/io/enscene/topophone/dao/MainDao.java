package io.enscene.topophone.dao;

import io.enscene.topophone.model.Main;
import io.enscene.topophone.model.Youtube;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class MainDao extends AstractHardCoded<Main> {

  @Override
  void init(Map<String, Main> database) {
    database.put("1", Main.of(HeadbandCarousel.of(getAllHeadbandImages(), "/images/education/headbandlogo.png"), getEnginedTemplate("main", "description"), Youtube.of("l3kcrbm2aNc"), Youtube.of("D1QOwfWPUZI")));
  }
  
  
  
}
