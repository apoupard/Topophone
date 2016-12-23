package io.enscene.topophone.dao;

import javax.inject.Singleton;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.model.Education;

@Singleton
@ForResource(Education.class)
public class EducationDao extends AbstractJsonDao<Education> {

}
