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
public class SectionsResourceTest {

  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment() {
    return TopophoneWebArchive.get();
  }

  @Test
  @RunAsClient
  public void should_getArtist(
      @ArquillianResteasyResource("html/sections/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains("/images/lecommondiamond.png");
  }

  @Test
  @RunAsClient
  public void should_getCreationSectionHtml(
      @ArquillianResteasyResource("html/sections/education/creation") ResteasyWebTarget webTarget) {
    String href =
        webTarget.queryParam("template", "section").request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains("<h1>Création musicale</h1>");
  }

  @Test
  @RunAsClient
  public void should_getPartners(
      @ArquillianResteasyResource("html/sections/partners") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    Assertions
        .assertThat(href)
        .contains(
            "<li><a onclick=\"document.getElementById('institutionnels').scrollIntoView()\">Institutionnels</a></li>")
        .contains(String.format("<img src=\"%simages/partners/fse.png\"/>", deploymentURL.getPath()));
  }

  @Test
  @RunAsClient
  public void should_getAllNav(
      @ArquillianResteasyResource("html/sections/nav") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains(
        String.format("<a href=\"%sappli/artist/lecommondiamond\">le common diamond</a>",
            deploymentURL.getPath()))
            .contains(String.format("<a href=\"%sappli/education/creation\">Création musicale</a>",
                deploymentURL.getPath()));
  }

//  @Test
//  @RunAsClient
//  public void should_getEducationNav(
//      @ArquillianResteasyResource("html/sections/subnav/education") ResteasyWebTarget webTarget) {
//    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
//    System.out.println(href);
//    Assertions.assertThat(href).contains(String.format("<a href=\"%sappli/education/creation\">Création musicale</a>",
//        deploymentURL.getPath()));
//  }
//
//  @Test
//  @RunAsClient
//  public void should_getSectionHtml(
//      @ArquillianResteasyResource("html/sections/header") ResteasyWebTarget webTarget) {
//    
//    String path = deploymentURL.getPath();
//    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
//    System.out.println(href);
//    Assertions.assertThat(href).contains(String.format("<img class=\"logo\" src=\"%simages/logo.png\">", path));
//  }
  
}
