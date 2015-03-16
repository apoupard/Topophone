package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;

public class Header implements ResourceModel {

  private String logo;

  public Header(String logo) {
    this.logo = logo;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }
  
}
