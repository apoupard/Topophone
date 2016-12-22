package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import io.enscene.topophone.api.ResourceModel;

import java.util.List;

@AutoValue
public abstract class NavEntry implements ResourceModel {

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder id(String id);

    public abstract Builder displayName(String displayName);

    public abstract Builder href(String href);

    public abstract Builder entries(List<NavEntry> entries);

    public abstract Builder styleNames(String styleNames);

    public abstract Builder isSelected(Boolean isSelected);

    public abstract NavEntry build();
  }

  public static NavEntry of(String id, String displayName, List<NavEntry> entries) {
    return new AutoValue_NavEntry.Builder().id(id).displayName(displayName).entries(entries)
        .isSelected(false).href("").styleNames("").build();
  }
  
  public static NavEntry of(String id, String displayName, String href, List<NavEntry> entries) {
    return new AutoValue_NavEntry.Builder().id(id).displayName(displayName).href(href).entries(entries)
        .isSelected(false).styleNames("").build();
  }

  public static NavEntry of(String id, String displayName, String href) {
    return new AutoValue_NavEntry.Builder().id(id).displayName(displayName).href(href)
        .isSelected(false).entries(ImmutableList.of()).styleNames("").build();
  }
  
  public static NavEntry of(String id, String displayName, String href, Boolean isSelected) {
    return new AutoValue_NavEntry.Builder().id(id).displayName(displayName).href(href).isSelected(isSelected)
        .entries(ImmutableList.of()).styleNames("").build();
  }

  public static NavEntry separator() {
    return new AutoValue_NavEntry.Builder().id("").displayName("").href("").entries(ImmutableList.of()).styleNames("separator").isSelected(false).build();
  }
  

  public static NavEntry smallSeparator() {
    return new AutoValue_NavEntry.Builder().id("").displayName("").href("").entries(ImmutableList.of()).styleNames("smallSeparator").isSelected(false).build();
  }

  public abstract String getId();

  public abstract String getDisplayName();

  public abstract String getHref();

  public abstract List<NavEntry> getEntries();

  public abstract String getStyleNames();

  public abstract Boolean getIsSelected();

}
