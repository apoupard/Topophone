package io.enscene.topophone.model.artist;

public class Video {
  
  private String thumbnail;
  private String description;

  public Video(String thumbnail, String description) {
    super();
    this.thumbnail = thumbnail;
    this.description = description;
  }
  
  public String getThumbnail() {
    return thumbnail;
  }
  
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

}
