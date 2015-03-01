package io.enscene.topophone;

import freemarker.template.Configuration;
import io.enscene.core.MicroService;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.templating.FreemakerTemplateEngine;
import io.enscene.topophone.templating.HtmlTemplateEngine;
import io.enscene.topophone.widget.dao.ArtistDao;
import io.enscene.topophone.widget.dao.EducationDao;
import io.enscene.topophone.widget.dao.PartnerDao;
import io.enscene.topophone.widget.dao.hardcoded.ArtistDaoHardCoded;
import io.enscene.topophone.widget.dao.hardcoded.EducationDaoHardCoded;
import io.enscene.topophone.widget.dao.hardcoded.PartnerDaoHardCoded;
import io.enscene.topophone.widget.resource.ArtistResource;
import io.enscene.topophone.widget.resource.EducationResource;
import io.enscene.topophone.widget.resource.HeaderResource;
import io.enscene.topophone.widget.resource.IndexResource;
import io.enscene.topophone.widget.resource.NavResource;
import io.enscene.topophone.widget.resource.PartnerResource;
import io.enscene.topophone.widget.resource.SectionsResource;

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
    
    
    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder, new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});

   
    resourceDaoBinder.addBinding("artist").to(ArtistDao.class);
    resourceDaoBinder.addBinding("education").to(EducationDao.class);
    resourceDaoBinder.addBinding("partners").to(PartnerDao.class);
  }

}
