package io.enscene.topophone.model.artist;

import java.util.List;

public class HeadbandCarousel {

  private String logo;
  private List<String> images;
  
  public HeadbandCarousel(List<String> images, String logo) {
    this.images = images;
    this.logo = logo;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }
  
}
