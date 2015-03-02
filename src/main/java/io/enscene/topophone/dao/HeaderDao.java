package io.enscene.topophone.dao;

import java.util.Optional;

import io.enscene.topophone.model.header.Header;


public interface HeaderDao {

  Header get(Optional<String> version);

}
