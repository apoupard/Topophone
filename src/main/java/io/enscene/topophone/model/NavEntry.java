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
  private Boolean isSelected;

  public static NavEntry of(String id, String displayName, List<NavEntry> entries) {
    return new NavEntry(id, displayName, "", entries, "", false);
  }
  
  public static NavEntry of(String id, String displayName, String href, List<NavEntry> entries) {
    return new NavEntry(id, displayName, href, entries, "", false);
  }

  public static NavEntry of(String id, String displayName, String href) {
    return new NavEntry(id, displayName, href, ImmutableList.of(), "", false);
  }
  
  public static NavEntry of(String id, String displayName, String href, Boolean isSelected) {
    return new NavEntry(id, displayName, href, ImmutableList.of(), "", isSelected);
  }

  public static NavEntry separator() {
    return new NavEntry("", "", "", ImmutableList.of(), "separator", false);
  }
  

  public static NavEntry smallSeparator() {
    return new NavEntry("", "", "", ImmutableList.of(), "smallSeparator", false);
  }


  public NavEntry(String id, String displayName, String href, List<NavEntry> entries, String styleNames, Boolean isSelected) {
    this.id = id;
    this.displayName = displayName;
    this.href = href;
    this.entries = entries;
    this.styleNames = styleNames;
    this.isSelected = isSelected;
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

  public Boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(Boolean isSelected) {
    this.isSelected = isSelected;
  }
  
  
}
