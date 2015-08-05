package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.Headband;

public class Contacts implements ResourceModel {

  private Headband headband;

  public Contacts(Headband headband) {
    super();
    this.headband = headband;
  }

  public Headband getHeadband() {
    return headband;
  }

  public void setHeadband(Headband headband) {
    this.headband = headband;
  }

}
