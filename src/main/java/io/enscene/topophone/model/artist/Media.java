package io.enscene.topophone.model.artist;

public class Media {

  private String id;
  private String href;
  
  public Media(String id, String href) {
    this.id = id;
    this.href = href;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

}
