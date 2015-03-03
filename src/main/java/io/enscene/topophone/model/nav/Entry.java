package io.enscene.topophone.model.nav;

import io.enscene.topophone.api.ResourceModel;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class Entry implements ResourceModel {

  private String id;
  private String displayName;
  private String href;
  private List<Entry> entries;
  private String styleNames;

  public static Entry of(String id, String displayName, String href, List<Entry> entries) {
    return new Entry(id, displayName, href, entries, "");
  }

  public static Entry of(String id, String displayName, String href) {
    return new Entry(id, displayName, href, ImmutableList.of(), "");
  }

  public static Entry separator() {
    return new Entry("", "", "", ImmutableList.of(), "separator");
  }
  

  public static Entry smallSeparator() {
    return new Entry("", "", "", ImmutableList.of(), "smallSeparator");
  }


  public Entry(String id, String displayName, String href, List<Entry> entries, String styleNames) {
    this.id = id;
    this.displayName = displayName;
    this.href = href;
    this.entries = entries;
    this.styleNames = styleNames;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

  public String getStyleNames() {
    return styleNames;
  }

  public void setStyleNames(String styleNames) {
    this.styleNames = styleNames;
  }
}
