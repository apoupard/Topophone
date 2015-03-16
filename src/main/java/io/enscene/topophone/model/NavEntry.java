package io.enscene.topophone.model;

import io.enscene.topophone.api.ResourceModel;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class NavEntry implements ResourceModel {

  private String id;
  private String displayName;
  private String href;
  private List<NavEntry> entries;
  private String styleNames;

  public static NavEntry of(String id, String displayName, String href, List<NavEntry> entries) {
    return new NavEntry(id, displayName, href, entries, "");
  }

  public static NavEntry of(String id, String displayName, String href) {
    return new NavEntry(id, displayName, href, ImmutableList.of(), "");
  }

  public static NavEntry separator() {
    return new NavEntry("", "", "", ImmutableList.of(), "separator");
  }
  

  public static NavEntry smallSeparator() {
    return new NavEntry("", "", "", ImmutableList.of(), "smallSeparator");
  }


  public NavEntry(String id, String displayName, String href, List<NavEntry> entries, String styleNames) {
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

  public List<NavEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<NavEntry> entries) {
    this.entries = entries;
  }

  public String getStyleNames() {
    return styleNames;
  }

  public void setStyleNames(String styleNames) {
    this.styleNames = styleNames;
  }
}
