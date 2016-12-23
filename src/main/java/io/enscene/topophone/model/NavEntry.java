package io.enscene.topophone.model;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutableNavEntry.class)
@JsonDeserialize(as = ImmutableNavEntry.class)
public interface NavEntry extends ResourceModel {

  public static NavEntry of(String id, String displayName, List<NavEntry> entries) {
    return ImmutableNavEntry.builder().id(id).displayName(displayName).entries(entries)
        .isSelected(false).href("").styleNames("").build();
  }
  
  public static NavEntry of(String id, String displayName, String href, List<NavEntry> entries) {
    return ImmutableNavEntry.builder().id(id).displayName(displayName).href(href).entries(entries)
        .isSelected(false).styleNames("").build();
  }

  public static NavEntry of(String id, String displayName, String href) {
    return ImmutableNavEntry.builder().id(id).displayName(displayName).href(href)
        .isSelected(false).entries(ImmutableList.of()).styleNames("").build();
  }
  
  public static NavEntry of(String id, String displayName, String href, Boolean isSelected) {
    return ImmutableNavEntry.builder().id(id).displayName(displayName).href(href).isSelected(isSelected)
        .entries(ImmutableList.of()).styleNames("").build();
  }

  public static NavEntry separator() {
    return ImmutableNavEntry.builder().id("").displayName("").href("").entries(ImmutableList.of()).styleNames("separator").isSelected(false).build();
  }
  

  public static NavEntry smallSeparator() {
    return ImmutableNavEntry.builder().id("").displayName("").href("").entries(ImmutableList.of()).styleNames("smallSeparator").isSelected(false).build();
  }

  String getId();

  String getDisplayName();

  String getHref();

  List<NavEntry> getEntries();

  String getStyleNames();

  Boolean getIsSelected();

}
