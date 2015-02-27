package io.enscene.topophone.widget.model.nav;

import java.util.List;

public class Nav {

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
