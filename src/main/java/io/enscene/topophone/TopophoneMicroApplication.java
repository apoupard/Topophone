package io.enscene.topophone;

import freemarker.template.Configuration;
import io.enscene.core.MicroService;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.dao.AccompanyingDao;
import io.enscene.topophone.dao.ArtistDao;
import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.dao.HeaderDao;
import io.enscene.topophone.dao.MainDao;
import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.dao.PartnersDao;
import io.enscene.topophone.resource.AccompanyingResource;
import io.enscene.topophone.resource.ArtistResource;
import io.enscene.topophone.resource.EducationResource;
import io.enscene.topophone.resource.PartnerResource;
import io.enscene.topophone.templating.FreemakerTemplateEngine;
import io.enscene.topophone.templating.HtmlTemplateEngine;
import io.enscene.topophone.templating.resource.HeaderResource;
import io.enscene.topophone.templating.resource.NavResource;
import io.enscene.topophone.templating.resource.SectionsResource;

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

    binder.bind(HtmlTemplateEngine.class).to(FreemakerTemplateEngine.class);
    binder.bind(Configuration.class).toProvider(FreemarkerConfigurationProvider.class);

    binder.bind(ArtistResource.class);
    binder.bind(NavResource.class);
    binder.bind(HeaderResource.class);
    binder.bind(PartnerResource.class);
    binder.bind(EducationResource.class);
    binder.bind(SectionsResource.class);
    binder.bind(AccompanyingResource.class);


    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder, new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});

    resourceDaoBinder.addBinding("artist").to(new TypeLiteral<ArtistDao>() {});
    resourceDaoBinder.addBinding("education").to(new TypeLiteral<EducationDao>() {});
    resourceDaoBinder.addBinding("partners").to(new TypeLiteral<PartnersDao>() {});
    resourceDaoBinder.addBinding("nav").to(new TypeLiteral<NavDao>() {});
    resourceDaoBinder.addBinding("header").to(new TypeLiteral<HeaderDao>() {});
    resourceDaoBinder.addBinding("main").to(new TypeLiteral<MainDao>() {});
    resourceDaoBinder.addBinding("accompanying").to(new TypeLiteral<AccompanyingDao>() {});
  }

}
