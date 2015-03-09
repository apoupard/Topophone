package io.enscene.topophone.model.artist;

import io.enscene.topophone.api.ResourceModel;

import java.util.List;

public class Artist implements ResourceModel {

  private String picture;
  private List<Media> medias;
  private List<Video> videos;
  private List<Concert> concerts;
  private Song song;
  private String description;
  private Headband headband;
  private String contactEmail;
  
  public Artist(String picture, List<Media> medias, Song song, List<Concert> concerts, String description, Headband headband, String contactEmail, List<Video> videos) {
    this.picture = picture;
    this.medias = medias;
    this.song = song;
    this.concerts = concerts;
    this.description = description;
    this.headband = headband;
    this.contactEmail = contactEmail;
    this.videos= videos; 
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public List<Media> getMedias() {
    return medias;
  }

  public void setMedias(List<Media> medias) {
    this.medias = medias;
  }

  public Song getSong() {
    return song;
  }

  public void setSong(Song song) {
    this.song = song;
  }

  public List<Concert> getConcerts() {
    return concerts;
  }

  public void setConcerts(List<Concert> concerts) {
    this.concerts = concerts;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Headband getHeadband() {
    return headband;
  }

  public void setHeadband(Headband headband) {
    this.headband = headband;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public List<Video> getVideos() {
    return videos;
  }

  public void setVideos(List<Video> videos) {
    this.videos = videos;
  }
}
