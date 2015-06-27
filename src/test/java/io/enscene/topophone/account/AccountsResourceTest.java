package io.enscene.topophone.account;

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
public class AccountsResourceTest {

  @ArquillianResource
  private URL deploymentURL;

  @Deployment
  public static WebArchive createDeployment() {
    return TopophoneWebArchive.get();
  }

  @Test
  @RunAsClient
  public void should_getJson(
      @ArquillianResteasyResource("html/accounts/lecommondiamond") ResteasyWebTarget webTarget) {
    String href = webTarget.request(MediaType.TEXT_PLAIN).get(String.class);
    Assertions.assertThat(href).isEqualTo("lecommondiamond");
  }


}
