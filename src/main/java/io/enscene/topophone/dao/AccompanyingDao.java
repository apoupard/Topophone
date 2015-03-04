package io.enscene.topophone.dao;

import java.util.Optional;

import io.enscene.topophone.model.accompanying.Accompanying;

public interface AccompanyingDao {
 
  Optional<Accompanying> get(Optional<String> version);
  
}
