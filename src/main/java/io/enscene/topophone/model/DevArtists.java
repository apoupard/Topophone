package io.enscene.topophone.model;

import java.util.List;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class DevArtists implements ResourceModel {

  private String id;
  private String description;
  private String image;
  private HeadbandCarousel headbandCarousel;
  private List<ArtistLink> artistLinks;

  public DevArtists(String id, String description, String image, HeadbandCarousel headbandCarousel,
      List<ArtistLink> artistLinks) {
    this.id = id;
    this.description = description;
    this.image = image;
    this.headbandCarousel = headbandCarousel;
    this.artistLinks = artistLinks;
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

  public void setHeadbandCarousel(HeadbandCarousel headband) {
    this.headbandCarousel = headband;
  }

  public List<ArtistLink> getArtistLinks() {
    return artistLinks;
  }

  public void setArtistLinks(List<ArtistLink> artistLinks) {
    this.artistLinks = artistLinks;
  }

  public static class ArtistLink {
    private String image;
    private String link;
    
    public ArtistLink(String image, String link) {
      super();
      this.image = image;
      this.link = link;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getLink() {
      return link;
    }

    public void setLink(String link) {
      this.link = link;
    }
  }
}
