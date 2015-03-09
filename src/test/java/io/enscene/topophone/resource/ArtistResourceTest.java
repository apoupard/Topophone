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
public class ArtistResourceTest {

  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment () {
    return TopophoneWebArchive.get();
  }

  @Test
  @RunAsClient
  public void should_getJson(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
    Assertions.assertThat(href).contains("images/artists/lecommondiamond/profile.png");
  }
  
  @Test
  @RunAsClient
  public void should_getProfileHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.queryParam("template", "profile").request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains(String.format("<img alt=\"\" src=\"%simages/artists/lecommondiamond/profile.png\"></img>", deploymentURL.getPath()));
  }
  
  
  @Test
  @RunAsClient
  public void should_getSongHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.queryParam("template", "audio").request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains("Go faster <span class=\"track-time\"> 00:00 / 3:52</span>");
  }
  
  @Test
  @RunAsClient
  public void should_getConcertHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.queryParam("template", "concert").request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains("<li>11 juil. -  Club liberté - Helsinki</li>");
  }
  
  @Test
  @RunAsClient
  public void should_getDescriptionHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.queryParam("template", "description").request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains("<p>Floran et Thomas puisent dans le solaire et");
  }
  
  @Test
  @RunAsClient
  public void should_getContactHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.queryParam("template", "contact").request(MediaType.TEXT_HTML).get(String.class);
    Assertions.assertThat(href).contains("<a href=\"mailto:contact@lecommundiamond.com\">CONTACT BOOKING</a>");
  }
  
  @Test
  @RunAsClient
  public void should_getSectionHtml(
      @ArquillianResteasyResource("html/artist/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_HTML).get(String.class);
    System.out.println(href);
    Assertions.assertThat(href).contains("<a href=\"mailto:contact@lecommundiamond.com\">CONTACT BOOKING</a>");
  }
}

