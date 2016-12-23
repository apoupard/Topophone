package io.enscene.topophone.model.partner;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableInstitution.class)
@JsonDeserialize(as = ImmutableInstitution.class)
public interface Institution {

  public static Institution of(String code, String displayName) {
    return ImmutableInstitution.builder().code(code).displayName(displayName).build();
  }

  String getCode();

  String getDisplayName();

}
