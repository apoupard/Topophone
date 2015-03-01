package io.enscene.topophone.templating;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;

import javax.inject.Inject;

import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemakerTemplateEngine implements HtmlTemplateEngine {

  private Configuration freemakerConfig;

  @Inject
  FreemakerTemplateEngine(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }

  @Override
  public String execute(String name, Optional<String> template, Object res) throws IOException,
      TemplateException {
    String templateName =
        new StringBuilder().append(name).append("/").append(template.orElse("section"))
            .append(".html").toString();

    Template temp = freemakerConfig.getTemplate(templateName);
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of(name, res), out);
    // return Processor.process(out.toString());
    return out.toString();
  }


}
