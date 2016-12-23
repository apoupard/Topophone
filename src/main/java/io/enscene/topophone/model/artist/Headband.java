package io.enscene.topophone.model.artist;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableHeadband.class)
@JsonDeserialize(as = ImmutableHeadband.class)
public interface Headband {

  public abstract String getMain();

  public abstract String getLogo();

  public static Headband of(String main, String logo) {
    return ImmutableHeadband.builder().main(main).logo(logo).build();
  }
}
