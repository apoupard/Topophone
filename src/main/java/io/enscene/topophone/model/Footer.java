package io.enscene.topophone.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;

@AutoValue
@JsonSerialize(as = Footer.class)
public abstract class Footer implements ResourceModel {

  @JsonCreator
  public static Footer of(String logo) {
    return new AutoValue_Footer();
  }

}
