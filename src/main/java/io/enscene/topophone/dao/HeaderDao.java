package io.enscene.topophone.dao;

import io.enscene.topophone.model.Header;

import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class HeaderDao extends AstractHardCoded<Header> {

  @Override
  void init(Map<String, Header> database) {
    database.put("1", new Header("/images/logo.png"));
  }

}
