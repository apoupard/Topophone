package io.enscene.topophone.dao;

import javax.inject.Singleton;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.model.Nav;

@Singleton
@ForResource(Nav.class)
public class NavDao extends AbstractJsonDao<Nav> {

}
