package io.enscene.topophone.model.artist;

public class Video {

  private String youtubeId;
  private String thumbnail;
  private String description;

  public Video(String youtubeId, String thumbnail, String description) {
    super();
    this.youtubeId=youtubeId;
    this.thumbnail = thumbnail;
    this.description = description;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getYoutubeVideo() {
    return new StringBuilder().append("http://www.youtube.com/v/").append(youtubeId).toString();
  }

  public String getYoutubeId() {
    return youtubeId;
  }

  public void setYoutubeId(String youtubeId) {
    this.youtubeId = youtubeId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
