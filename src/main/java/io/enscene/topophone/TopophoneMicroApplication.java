package io.enscene.topophone;

import freemarker.template.Configuration;
import io.enscene.core.MicroService;
import io.enscene.topophone.widget.dao.ArtistDao;
import io.enscene.topophone.widget.dao.hardcoded.ArtistDaoHardCoded;
import io.enscene.topophone.widget.resource.ArtistResource;
import io.enscene.topophone.widget.resource.EducationResource;
import io.enscene.topophone.widget.resource.HeaderResource;
import io.enscene.topophone.widget.resource.IndexResource;
import io.enscene.topophone.widget.resource.NavResource;
import io.enscene.topophone.widget.resource.PartnerResource;

import javax.ws.rs.ApplicationPath;

import com.google.inject.Binder;
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
    
    binder.bind(ArtistDao.class).to(ArtistDaoHardCoded.class);
  }

//  @Provides
//  Configuration freemaker() throws IOException, TemplateModelException {
//    Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
//    cfg.setClassForTemplateLoading(this.getClass(), "/template");
//    cfg.setDefaultEncoding("UTF-8");
//    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER); 
//    cfg.setSharedVariable("appcontext", Servlet.APPLICATION_CONTEXT);
//    return cfg;
//  }
  
  

}
