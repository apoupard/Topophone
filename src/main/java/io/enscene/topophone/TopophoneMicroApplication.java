package io.enscene.topophone;

import freemarker.template.Configuration;
import io.enscene.core.MicroService;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.dao.ArtistDao;
import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.dao.HeaderDao;
import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.dao.PartnerDao;
import io.enscene.topophone.dao.hardcoded.ArtistDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.EducationDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.HeaderDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.NavDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.PartnerDaoHardCoded;
import io.enscene.topophone.resource.ArtistResource;
import io.enscene.topophone.resource.EducationResource;
import io.enscene.topophone.resource.HeaderResource;
import io.enscene.topophone.resource.IndexResource;
import io.enscene.topophone.resource.NavResource;
import io.enscene.topophone.resource.PartnerResource;
import io.enscene.topophone.resource.SectionsResource;
import io.enscene.topophone.templating.FreemakerTemplateEngine;
import io.enscene.topophone.templating.HtmlTemplateEngine;

import javax.ws.rs.ApplicationPath;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.servlet.ServletModule;

@ApplicationPath("html")
public class TopophoneMicroApplication extends MicroService {

  @Override
  public void configure(Binder binder) {
    binder.install(new ServletModule());
    
    binder.bind(Configuration.class).toProvider(FmConfigProvider.class);
   
    binder.bind(ArtistResource.class);
    binder.bind(NavResource.class);
    binder.bind(HeaderResource.class);
    binder.bind(PartnerResource.class);
    binder.bind(EducationResource.class);
    binder.bind(IndexResource.class);
    binder.bind(SectionsResource.class);
   
    binder.bind(HtmlTemplateEngine.class).to(FreemakerTemplateEngine.class);
   
    binder.bind(ArtistDao.class).to(ArtistDaoHardCoded.class);
    binder.bind(EducationDao.class).to(EducationDaoHardCoded.class);
    binder.bind(PartnerDao.class).to(PartnerDaoHardCoded.class);
    binder.bind(NavDao.class).to(NavDaoHardCoded.class);
    binder.bind(HeaderDao.class).to(HeaderDaoHardCoded.class);
    
    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder, new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});

   
    resourceDaoBinder.addBinding("artist").to(ArtistDao.class);
    resourceDaoBinder.addBinding("education").to(EducationDao.class);
    resourceDaoBinder.addBinding("partners").to(PartnerDao.class);
    resourceDaoBinder.addBinding("nav").to(NavDao.class);
    resourceDaoBinder.addBinding("subnav").to(NavDao.class);
  }

}
