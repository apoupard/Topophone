package io.enscene.topophone.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;

@AutoValue
@JsonDeserialize(builder = AutoValue_Header.Builder.class)
public abstract class Header implements ResourceModel {

  public static Header of(String logo) {
    return new AutoValue_Header.Builder().logo(logo).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder logo(String logo);

    public abstract Header build();
  }

  public abstract String getLogo();

}
