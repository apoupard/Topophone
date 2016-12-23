package io.enscene.topophone.model;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutableNav.class)
@JsonDeserialize(as = ImmutableNav.class)
public interface Nav extends ResourceModel {

  public static Nav of(List<NavEntry> entries) {
    return ImmutableNav.builder().entries(entries).build();
  }

  List<NavEntry> getEntries();

}
