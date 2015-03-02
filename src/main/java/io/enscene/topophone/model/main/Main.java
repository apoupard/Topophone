package io.enscene.topophone.model.main;

import io.enscene.topophone.api.ResourceModel;

import java.util.Collection;

public class Main implements ResourceModel {

  private Collection<String> images;
  
  private String description;
  
  private String demarche;
  
  public Main(Collection<String> images, String description, String demarche) {
    this.images = images;
    this.description = description;
    this.demarche = demarche;
  }

  public Collection<String> getImages() {
    return images;
  }

  public void setImages(Collection<String> images) {
    this.images = images;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDemarche() {
    return demarche;
  }

  public void setDemarche(String demarche) {
    this.demarche = demarche;
  }

}
