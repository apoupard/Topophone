package io.enscene.topophone.model;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutableFooter.class)
@JsonDeserialize(as = ImmutableFooter.class)
public interface Footer extends ResourceModel {

  public static Footer of() {
    return ImmutableFooter.builder().build();
  }

}
