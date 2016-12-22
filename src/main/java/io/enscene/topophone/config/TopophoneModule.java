package io.enscene.topophone.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ziplet.filter.compression.CompressingFilter;
import com.google.inject.Binding;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.servlet.ServletModule;
import freemarker.template.Configuration;
import io.enscene.topophone.api.ResourceDao;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.config.templating.FreemarkerConfigurationProvider;
import io.enscene.topophone.dao.*;
import io.enscene.topophone.config.templating.FreemarkerTemplateEngine;
import io.enscene.topophone.api.HtmlTemplateEngine;
import io.enscene.topophone.resource.SectionsResource;
import io.enscene.topophone.resource.XmlResource;
import ro.isdc.wro.http.WroFilter;

public class TopophoneModule extends ServletModule {

  @Override
  protected void configureServlets() {

    bind(HtmlTemplateEngine.class).to(FreemarkerTemplateEngine.class);
    bind(Configuration.class).toProvider(FreemarkerConfigurationProvider.class);

    bind(SectionsResource.class);
    bind(XmlResource.class);

    MapBinder<String, ResourceDao<? extends ResourceModel>> resourceDaoBinder =
        MapBinder.newMapBinder(binder(), new TypeLiteral<String>() {},
            new TypeLiteral<ResourceDao<? extends ResourceModel>>() {});

    resourceDaoBinder.addBinding("index").to(new TypeLiteral<IndexDao>() {});
    resourceDaoBinder.addBinding("devartists").to(new TypeLiteral<DevArtistsDao>() {});
    resourceDaoBinder.addBinding("artist").to(new TypeLiteral<ArtistDao>() {});
    resourceDaoBinder.addBinding("education").to(new TypeLiteral<EducationDao>() {});
    resourceDaoBinder.addBinding("partners").to(new TypeLiteral<PartnersDao>() {});
    resourceDaoBinder.addBinding("nav").to(new TypeLiteral<NavDao>() {});
    resourceDaoBinder.addBinding("header").to(new TypeLiteral<HeaderDao>() {});
//    resourceDaoBinder.addBinding("main").to(new TypeLiteral<MainDao>() {});
    resourceDaoBinder.addBinding("footer").to(new TypeLiteral<FooterDao>() {});
    resourceDaoBinder.addBinding("contacts").to(new TypeLiteral<ContactsDao>() {});

    bind(Servlet.class).asEagerSingleton();
    bind(WroFilter.class).asEagerSingleton();

    serve("/", "/index.html", Servlet.APPLICATION_CONTEXT + "/*").with(Servlet.class);
    filter("/wro/*").through(WroFilter.class);

    bind(CompressingFilter.class).asEagerSingleton();
    filter("/wro/*", "/images/*, /music/*").through(CompressingFilter.class);
  }


}
