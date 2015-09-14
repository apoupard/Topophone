package io.enscene.topophone.model.artist;

import java.util.Date;
import java.util.GregorianCalendar;

public class Concert {

  public static Concert of(int day, int month, int year, String place, String city) {
    return new Concert(new GregorianCalendar(year, month, day).getTime(), place, city);
  }

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
