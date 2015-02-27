package io.enscene.topophone.widget.model.artist;

import java.util.Date;

public class Concert {

  private Date date;
  private String place;
  private String city;

  public Concert(Date date, String place, String city) {
    this.date = date;
    this.place = place;
    this.city = city;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
