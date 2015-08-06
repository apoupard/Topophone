package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Main implements ResourceModel {

  private final HeadbandCarousel headband;
  
  public Main(HeadbandCarousel headband) {
    this.headband = headband;
  }

  public HeadbandCarousel getHeadbandCarousel() {
    return headband;
  }
  
}
