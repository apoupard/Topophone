package io.enscene.topophone.dao;

import javax.inject.Singleton;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.model.partner.Partners;

@Singleton
@ForResource(Partners.class)
public class PartnersDao extends AbstractJsonDao<Partners> {

}
