package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class Education implements ResourceModel {

  private String id;
  private String imageLeft;
  private String description;
  private String image;
  private HeadbandCarousel headbandCarousel;
  private Nav subNav;


  public Education(String id, String imageLeft, String description, String image, HeadbandCarousel headbandCarousel, Nav subNav) {
    this.id = id;
    this.imageLeft = imageLeft;
    this.description = description;
    this.image = image;
    this.headbandCarousel = headbandCarousel;
    this.subNav = subNav;
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
    return headbandCarousel;
  }

  public void setHeadbandCarousel(HeadbandCarousel headbandCarousel) {
    this.headbandCarousel = headbandCarousel;
  }

  public Nav getSubNav() {
    return subNav;
  }

  public void setSubNav(Nav subNav) {
    this.subNav = subNav;
  }
  
}
