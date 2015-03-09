package io.enscene.topophone.resource;

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
public class AccompanyingResourceTest {

  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment() {
    return TopophoneWebArchive.get();
  }

  @Test
  @RunAsClient
  public void should_getHtlm(
      @ArquillianResteasyResource("html/accompanying") ResteasyWebTarget webTarget) {
    String html = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(html);
    Assertions.assertThat(html).contains("<p>Professionnaliser le projet musical des groupes</p>");
  }

  @Test
  @RunAsClient
  public void should_getHeadBand(
      @ArquillianResteasyResource("html/accompanying") ResteasyWebTarget webTarget) {
    String html = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(html);
    Assertions.assertThat(html)
      .contains(String.format("<img class=\"main\" alt=\"\" src=\"%simages/accompanying/headband.png\">", deploymentURL.getPath()))
      .contains(String.format("<img class=\"logo\" alt=\"\" src=\"%simages/accompanying/headbandlogo.png\">", deploymentURL.getPath()));
  }
}
