package io.enscene.topophone;

import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.servlet.ServletModule;

import freemarker.template.Configuration;
import io.enscene.topophone.account.AccountsResource;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.dao.AccompanyingDao;
import io.enscene.topophone.dao.ArtistDao;
import io.enscene.topophone.dao.ContactsDao;
import io.enscene.topophone.dao.DevArtistsDao;
import io.enscene.topophone.dao.EducationDao;
import io.enscene.topophone.dao.FooterDao;
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
import io.enscene.topophone.templating.resource.IndexResource;
import io.enscene.topophone.templating.resource.NavResource;
import io.enscene.topophone.templating.resource.SectionsResource;

public class TopophoneModule extends ServletModule {
  
  

  @Override
  protected void configureServlets() {
    
    bind(HtmlTemplateEngine.class).to(FreemakerTemplateEngine.class);
    bind(Configuration.class).toProvider(FreemarkerConfigurationProvider.class);

    bind(AccountsResource.class);
    bind(ArtistResource.class);
    bind(NavResource.class);
    bind(HeaderResource.class);
    bind(PartnerResource.class);
    bind(EducationResource.class);
    bind(SectionsResource.class);
    bind(AccompanyingResource.class);
    bind(IndexResource.class);
    
    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder(), new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});

    resourceDaoBinder.addBinding("devartists").to(new TypeLiteral<DevArtistsDao>() {});
    resourceDaoBinder.addBinding("artist").to(new TypeLiteral<ArtistDao>() {});
    resourceDaoBinder.addBinding("education").to(new TypeLiteral<EducationDao>() {});
    resourceDaoBinder.addBinding("partners").to(new TypeLiteral<PartnersDao>() {});
    resourceDaoBinder.addBinding("nav").to(new TypeLiteral<NavDao>() {});
    resourceDaoBinder.addBinding("header").to(new TypeLiteral<HeaderDao>() {});
    resourceDaoBinder.addBinding("main").to(new TypeLiteral<MainDao>() {});
    resourceDaoBinder.addBinding("accompanying").to(new TypeLiteral<AccompanyingDao>() {});
    resourceDaoBinder.addBinding("footer").to(new TypeLiteral<FooterDao>() {});
    resourceDaoBinder.addBinding("contacts").to(new TypeLiteral<ContactsDao>() {});
    bind(Servlet.class).asEagerSingleton();
    
    serve("/", "/index.html", Servlet.APPLICATION_CONTEXT + "/*").with(Servlet.class);
  }

}
