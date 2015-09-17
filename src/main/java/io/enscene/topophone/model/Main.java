package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Main implements ResourceModel {

  private final HeadbandCarousel headband;
  private final Youtube videoLeft;
  private final Youtube videoRight;
  
  private String description;
  
  public Main(HeadbandCarousel headband, String description, Youtube videoLeft, Youtube videoRight) {
    this.headband = headband;
    this.description = description;
    this.videoLeft = videoLeft;
    this.videoRight = videoRight;
  }

  public HeadbandCarousel getHeadbandCarousel() {
    return headband;
  }

  public String getDescription() {
    return description;
  }

  public Youtube getVideoLeft() {
    return videoLeft;
  }

  public Youtube getVideoRight() {
    return videoRight;
  }
  
}
