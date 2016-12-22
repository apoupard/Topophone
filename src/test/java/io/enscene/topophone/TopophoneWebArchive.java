package io.enscene.topophone;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TopophoneWebArchive {

  public static WebArchive get() {
    WebArchive archive = ShrinkWrap
        .create(WebArchive.class)
        .addPackages(true, "io.enscene.topophone")
        .addAsLibraries(
            Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
                .resolve().withTransitivity().asFile());
     return archive;
  }
}
