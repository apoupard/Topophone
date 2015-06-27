package io.enscene.topophone;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TopophoneWebArchive {

  public static WebArchive get() {
    WebArchive archive = ShrinkWrap
        .create(WebArchive.class)
        .addPackages(true, TopophoneGuiceConfiguration.class.getPackage())
        .addAsLibraries(
            Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
                .resolve().withTransitivity().asFile());
    System.out.println(archive.toString(true));
     return archive;
  }
}
