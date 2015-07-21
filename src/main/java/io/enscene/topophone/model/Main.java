package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.Headband;

public class Main implements ResourceModel {

  private final Headband headband;
  
  public Main(Headband headband) {
    this.headband = headband;
  }

  public Headband getHeadband() {
    return headband;
  }
  
}
