package io.enscene.topophone.dao;

import java.util.Map;

import javax.inject.Singleton;

import io.enscene.topophone.model.Main;
import io.enscene.topophone.model.artist.Headband;

@Singleton
public class MainDao extends AstractHardCoded<Main> {

  @Override
  void init(Map<String, Main> database) {
    database.put("1", new Main(new Headband("/images/education/headband.png", "/images/education/headbandlogo.png")));
  }
  
}
