package io.enscene.topophone.api;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import freemarker.template.TemplateException;

public interface HtmlTemplateEngine {

  String execute(String name, Optional<String> template, Map<String, Object> res) throws IOException, TemplateException;

}
