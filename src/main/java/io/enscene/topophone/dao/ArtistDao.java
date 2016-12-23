package io.enscene.topophone.dao;

import javax.inject.Singleton;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.model.artist.Artist;

@Singleton
@ForResource(Artist.class)
public class ArtistDao extends AbstractJsonDao<Artist> {
}
