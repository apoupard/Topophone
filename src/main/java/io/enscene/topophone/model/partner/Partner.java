package io.enscene.topophone.model.partner;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutablePartner.class)
@JsonDeserialize(as = ImmutablePartner.class)
public interface Partner extends ResourceModel {

  public static Partner of(String type, String logo, String description) {
    return ImmutablePartner.builder().type(type).logo(logo).description(description).build();
  }

  String getLogo();

  String getDescription();

  String getType();

}
