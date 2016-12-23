package io.enscene.topophone.dao;

import javax.inject.Singleton;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.model.DevArtists;

@Singleton
@ForResource(DevArtists.class)
public class DevArtistsDao extends AbstractJsonDao<DevArtists> {

}
