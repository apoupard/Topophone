package io.enscene.topophone.widget.dao;

import io.enscene.topophone.widget.model.artist.Artist;

import java.util.Collection;
import java.util.Optional;

public interface ArtistDao {

  Optional<Artist> get(String id);
  
  Collection<Artist> getAll();
}
