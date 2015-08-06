package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Contacts implements ResourceModel {

  private HeadbandCarousel headbandCarousel;

  public Contacts(HeadbandCarousel headbandCarousel) {
    super();
    this.headbandCarousel = headbandCarousel;
  }

  public HeadbandCarousel getHeadbandCarousel() {
    return headbandCarousel;
  }

  public void setHeadbandCarousel(HeadbandCarousel headbandCarousel) {
    this.headbandCarousel = headbandCarousel;
  }

}
