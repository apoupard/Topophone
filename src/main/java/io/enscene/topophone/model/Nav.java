package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;

import java.util.List;

public class Nav implements ResourceModel{

  List<NavEntry> entries;

  public Nav(List<NavEntry> entries) {
    super();
    this.entries = entries;
  }

  public List<NavEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<NavEntry> entries) {
    this.entries = entries;
  }

}
