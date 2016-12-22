package io.enscene.topophone.dao;

import io.enscene.topophone.model.Footer;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class IndexDao extends AstractHardCoded<Footer> {

  @Override
  void init(Map<String, Footer> database) {
    database.put("1", Footer.of(""));
  }

}
