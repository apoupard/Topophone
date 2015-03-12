package io.enscene.topophone;

import freemarker.template.Configuration;
import io.enscene.core.MicroService;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.dao.hardcoded.AccompanyingDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.ArtistDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.EducationDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.HeaderDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.MainDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.NavDaoHardCoded;
import io.enscene.topophone.dao.hardcoded.PartnersDaoHardCoded;
import io.enscene.topophone.resource.AccompanyingResource;
import io.enscene.topophone.resource.ArtistResource;
import io.enscene.topophone.resource.EducationResource;
import io.enscene.topophone.resource.HeaderResource;
import io.enscene.topophone.resource.IndexResource;
import io.enscene.topophone.resource.MainResource;
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
    binder.bind(MainResource.class);
    binder.bind(AccompanyingResource.class);
    
    
    binder.bind(HtmlTemplateEngine.class).to(FreemakerTemplateEngine.class);

    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder, new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});
   
    resourceDaoBinder.addBinding("artist").to(new TypeLiteral<ArtistDaoHardCoded>() {});
    resourceDaoBinder.addBinding("education").to(new TypeLiteral<EducationDaoHardCoded>(){});
    resourceDaoBinder.addBinding("partners").to(new TypeLiteral<PartnersDaoHardCoded>(){});
    resourceDaoBinder.addBinding("nav").to(new TypeLiteral<NavDaoHardCoded>(){});
    resourceDaoBinder.addBinding("header").to(new TypeLiteral<HeaderDaoHardCoded>(){});
    resourceDaoBinder.addBinding("main").to(new TypeLiteral<MainDaoHardCoded>(){});
    resourceDaoBinder.addBinding("accompanying").to(new TypeLiteral<AccompanyingDaoHardCoded>(){});
  }

}
