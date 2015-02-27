package io.enscene.topophone.widget.model.education;

public class Education {

  private String id;
  private String description;
  private String image;
  
  public Education(String id, String description, String image) {
    this.id = id;
    this.description = description;
    this.image = image;
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
  
}
