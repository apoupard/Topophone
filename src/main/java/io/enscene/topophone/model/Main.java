package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Main implements ResourceModel {

  private final HeadbandCarousel headband;
  
  private String description;
  
  public Main(HeadbandCarousel headband, String description) {
    this.headband = headband;
    this.description = description;
  }

  public HeadbandCarousel getHeadbandCarousel() {
    return headband;
  }

  public String getDescription() {
    return description;
  }
 
}
