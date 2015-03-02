package io.enscene.topophone.dao.hardcoded;

import java.util.Optional;

import io.enscene.topophone.dao.HeaderDao;
import io.enscene.topophone.model.header.Header;

import javax.inject.Singleton;

@Singleton
public class HeaderDaoHardCoded implements HeaderDao {

  @Override
  public Header get(Optional<String> version) {
    return new Header("/images/logo.png");
  }

}
