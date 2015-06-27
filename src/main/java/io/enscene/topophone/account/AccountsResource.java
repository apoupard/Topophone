package io.enscene.topophone.account;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresAuthentication;

@Path("accounts")
public class AccountsResource {
  
  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  @RequiresAuthentication
  public String get(@PathParam("name") String name) {
    return name;
  }

}
