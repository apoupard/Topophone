package io.enscene.topophone.model.accompanying;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableContact.class)
@JsonDeserialize(as = ImmutableContact.class)
public interface Contact {

  public static ImmutableContact.Builder builder() {
    return ImmutableContact.builder();
  }

  String getName();

  String getPhone();

  String getEmail();

  String getAddress();

}
