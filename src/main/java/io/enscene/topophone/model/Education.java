package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Education implements ResourceModel {

  private String id;
  private String imageLeft;
  private String description;
  private String image;
  private HeadbandCarousel headband;

  public Education(String id, String imageLeft, String description, String image, HeadbandCarousel headband) {
    this.id = id;
    this.imageLeft = imageLeft;
    this.description = description;
    this.image = image;
    this.headband = headband;
  }
  
  public String getImageLeft() {
    return imageLeft;
  }

  public void setImageLeft(String imageLeft) {
    this.imageLeft = imageLeft;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public HeadbandCarousel getHeadbandCarousel() {
    return headband;
  }

  public void setHeadbandCarousel(HeadbandCarousel headband) {
    this.headband = headband;
  }

}
