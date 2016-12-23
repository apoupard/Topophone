package io.enscene.topophone.model;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutableHeader.class)
@JsonDeserialize(as = ImmutableHeader.class)
public interface Header extends ResourceModel {

  public static Header of(String logo) {
    return ImmutableHeader.builder().logo(logo).build();
  }
  
  String getLogo();

}
