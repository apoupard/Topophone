package io.enscene.topophone.widget.model.partner;

import io.enscene.topophone.api.ResourceModel;

public class Partner implements ResourceModel {

  private String type;
  private String logo;
  private String description;

  public Partner(String type, String logo, String description) {
    this.type = type;
    this.logo = logo;
    this.description = description;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
