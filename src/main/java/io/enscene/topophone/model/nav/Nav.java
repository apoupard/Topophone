package io.enscene.topophone.model.nav;

import io.enscene.topophone.api.ResourceModel;

import java.util.List;

public class Nav implements ResourceModel{

  List<Entry> entries;

  public Nav(List<Entry> entries) {
    super();
    this.entries = entries;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

}
