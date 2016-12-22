package io.enscene.topophone.dao;

import io.enscene.topophone.model.Header;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class HeaderDao extends AstractHardCoded<Header> {

  @Override
  void init(Map<String, Header> database) {
    database.put("1", Header.of("/images/logo.png"));
  }

}
