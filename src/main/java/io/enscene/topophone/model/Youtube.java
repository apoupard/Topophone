package io.enscene.topophone.model;

public class Youtube {

  private String youtubeId;

  public Youtube(String youtubeId) {
    this.youtubeId = youtubeId;
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

}
