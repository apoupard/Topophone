package io.enscene.topophone.model.artist;

public class Video {

  private String youtubeId;
  private String title;
  private String date;
  private String mix;
  private String production;
  
  public Video(String youtubeId, String title, String date, String mix, String production) {
    this.youtubeId = youtubeId;
    this.title = title;
    this.date = date;
    this.mix = mix;
    this.production = production;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getMix() {
    return mix;
  }

  public void setMix(String mix) {
    this.mix = mix;
  }

  public String getProduction() {
    return production;
  }

  public void setProduction(String production) {
    this.production = production;
  }


}
