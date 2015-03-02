package io.enscene.topophone.dao;

import io.enscene.topophone.model.main.Main;

import java.util.Optional;

public interface MainDao {

  Optional<Main> get(Optional<String> version);
  
}
