package io.enscene.topophone.templating.resource;

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
public class NavResourceTest {

  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment () {
    return TopophoneWebArchive.get();
  }

  @Test
  @RunAsClient
  public void should_getSectionHtml(
      @ArquillianResteasyResource("html/nav") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains(String.format("<a href=\"%sappli/artist/lecommondiamond\" class=\"verticalCenter\">Le Common Diamond</a>", deploymentURL.getPath()));
  }
  
//  @Test
//  @RunAsClient
//  public void should_getSubSectionHtml(
//      @ArquillianResteasyResource("html/nav/education") ResteasyWebTarget webTarget) {
//    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
//    System.out.println(href);
//    Assertions.assertThat(href).contains(String.format("<a href=\"%sappli/education/creation\">Création musicale</a>",
//        deploymentURL.getPath()));
//   }
  
}

