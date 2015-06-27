package io.enscene.topophone;

import javax.servlet.ServletContext;

import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;

import com.google.inject.Provides;

public class ShiroConfiguration extends ShiroWebModule {

  public ShiroConfiguration(ServletContext servletContext) {
    super(servletContext);
  }

  @Override
  protected void configureShiroWeb() {
    try {
      bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
    } catch (NoSuchMethodException e) {
      addError(e);
    }
  }
  
  @Provides
  Ini loadShiroIni() {
    Ini ini = Ini.fromResourcePath("classpath:shiro.ini");
    return ini;
  }

}
