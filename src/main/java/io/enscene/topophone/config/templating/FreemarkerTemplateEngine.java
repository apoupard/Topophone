package io.enscene.topophone.config.templating;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.enscene.topophone.api.HtmlTemplateEngine;

public class FreemarkerTemplateEngine implements HtmlTemplateEngine {

  private static final Logger logger = LoggerFactory.getLogger(FreemarkerTemplateEngine.class);

  private Configuration freemarkerConfig;

  @Inject
  public FreemarkerTemplateEngine(Configuration freemarkerConfig) {
    this.freemarkerConfig = freemarkerConfig;
  }

  @Override
  public String execute(String name, Optional<String> template, Map<String, Object> res)
      throws IOException, TemplateException {

    String templateName = buildTemplateName(name, template);
    String processedTemplate = processTemplate(templateName, res);
    logger.debug("Processed template: {}", processedTemplate);
    
    return processedTemplate;
  }

  private String buildTemplateName(String name, Optional<String> template) {
    return new StringBuilder().append(name).append("/")
          .append(template.orElse("section")).append(".flt").toString();
  }

  private String processTemplate(String templateName, Map<String, Object> res) throws IOException, TemplateException {
    StringWriter out = new StringWriter();
    Template temp = freemarkerConfig.getTemplate(templateName);
    temp.process(res, out);
    return out.toString();
  }
  
}
