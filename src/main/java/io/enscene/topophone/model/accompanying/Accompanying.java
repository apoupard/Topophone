package io.enscene.topophone.model.accompanying;

import io.enscene.topophone.model.artist.Headband;

import java.util.Collection;

public class Accompanying {
  
  private Headband headband;
  
  private Collection<String> objectives;

  private Contact contact;

  private String description;
  private String picture;

  public Accompanying(Headband headband, Collection<String> objectives, Contact contact, String description, String picture) {
    this.headband = headband;
    this.objectives = objectives;
    this.contact = contact;
    this.description = description;
    this.picture = picture;
  }
  
  public Headband getHeadband() {
    return headband;
  }

  public void setHeadband(Headband headband) {
    this.headband = headband;
  }

  public Collection<String> getObjectives() {
    return objectives;
  }

  public void setObjectives(Collection<String> objectives) {
    this.objectives = objectives;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
  
}
