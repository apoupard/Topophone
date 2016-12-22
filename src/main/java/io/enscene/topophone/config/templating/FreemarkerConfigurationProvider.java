package io.enscene.topophone.config.templating;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateModelException;
import io.enscene.topophone.config.Servlet;

public class FreemarkerConfigurationProvider implements Provider<Configuration> {

  private final ServletContext context;
  
  @Inject FreemarkerConfigurationProvider(ServletContext context) {
    super();
    this.context = context;
  }

  @Override
  public Configuration get() {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
    cfg.setClassForTemplateLoading(this.getClass(), "/template");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER); 
    try {
      cfg.setSharedVariable("restcontext", context.getContextPath()+ Servlet.APPLICATION_CONTEXT);
      cfg.setSharedVariable("appcontext", context.getContextPath());
    } catch (TemplateModelException e) {
      e.printStackTrace();
    }
    return cfg;
  }

}
