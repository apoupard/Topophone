package io.enscene.topophone.model.artist;

public class Video {

  private String youtubeId;
  private String description;

  public Video(String youtubeId, String description) {
    this.youtubeId = youtubeId;
    this.description = description;
  }

  public String getThumbnail() {
    return new StringBuilder().append("https://i.ytimg.com/vi/").append(youtubeId).append("/hqdefault.jpg").toString();
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
