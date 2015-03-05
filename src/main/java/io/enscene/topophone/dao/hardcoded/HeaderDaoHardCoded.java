package io.enscene.topophone.dao.hardcoded;

import io.enscene.topophone.dao.HeaderDao;
import io.enscene.topophone.model.header.Header;

import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class HeaderDaoHardCoded extends AstractHardCoded<Header> implements HeaderDao {

  @Override
  void init(Map<String, Header> database) {
    database.put("1", new Header("/images/logo.png"));
  }

}
