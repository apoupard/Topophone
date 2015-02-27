package io.enscene.topophone.widget.resource;

import io.enscene.topophone.TopophoneWebArchive;

import java.net.URL;

import javax.ws.rs.core.MediaType;

import org.assertj.core.api.Assertions;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EducationResourceTest {
  
  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment () {
    WebArchive archive = TopophoneWebArchive.get();
    System.out.println(archive.toString(true));
    return archive;
  }

  @Test
  @RunAsClient
  public void should_getCreationSectionHtml(
      @ArquillianResteasyResource("html/education/creation/section") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains("<h1>Création musicale</h1>");
  }
  
  @Test
  @RunAsClient
  public void should_getInitiationSectionHtml(
      @ArquillianResteasyResource("html/education/initiation/section") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains("<h1>Initiation à l’écoute</h1>");
  }
  
  @Test
  @RunAsClient
  public void should_getMeetingSectionHtml(
      @ArquillianResteasyResource("html/education/meeting/section") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains("<h1>Rencontre d’artistes</h1>");
  }
}

