package io.enscene.topophone.templating;

import java.io.IOException;
import java.util.Optional;

import freemarker.template.TemplateException;

public interface HtmlTemplateEngine {

  String execute(String name, Optional<String> template, Object res) throws IOException, TemplateException;

}
