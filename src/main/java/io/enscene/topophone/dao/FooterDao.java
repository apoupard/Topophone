package io.enscene.topophone.dao;

import java.util.Map;

import javax.inject.Singleton;

import io.enscene.topophone.model.Footer;

@Singleton
public class FooterDao extends AstractHardCoded<Footer> {

  @Override
  void init(Map<String, Footer> database) {
    database.put("1", new Footer());
  }

}
