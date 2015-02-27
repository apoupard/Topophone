package io.enscene.topophone;

import io.enscene.topophone.TopophoneMicroApplication;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TopophoneWebArchive {

  public static WebArchive get() {
    return ShrinkWrap
        .create(WebArchive.class)
        .addPackages(true, TopophoneMicroApplication.class.getPackage())
        .addAsLibraries(
            Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
                .resolve().withTransitivity().asFile());

  }
}
