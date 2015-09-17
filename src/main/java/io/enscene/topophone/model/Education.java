package io.enscene.topophone.model;

import java.util.List;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;
import io.enscene.topophone.model.artist.Song;

public class Education implements ResourceModel {

  private String id;
  private String imageLeft;
  private String description;
  private Youtube video;
  private HeadbandCarousel headbandCarousel;
  private Nav subNav;
  private List<Song> songs;

  public Education(String id, String imageLeft, String description, Youtube video, HeadbandCarousel headbandCarousel, Nav subNav, List<Song> songs) {
    this.id = id;
    this.imageLeft = imageLeft;
    this.description = description;
    this.video = video;
    this.headbandCarousel = headbandCarousel;
    this.subNav = subNav;
    this.songs = songs;
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

  public Youtube getVideo() {
    return video;
  }

  public void setVideo(Youtube video) {
    this.video = video;
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
  
  public List<Song> getSongs() {
    return songs;
  }

  public void setSong(List<Song> songs) {
    this.songs = songs;
  }
  
}
