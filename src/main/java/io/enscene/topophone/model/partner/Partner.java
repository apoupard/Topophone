package io.enscene.topophone.model.partner;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;

@AutoValue
public abstract class Partner implements ResourceModel {

  public static Partner of(String type, String logo, String description) {
    return new AutoValue_Partner.Builder().type(type).logo(logo).description(description).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder type(String type);

    public abstract Builder logo(String logo);

    public abstract Builder description(String description);

    public abstract Partner build();
  }

  public abstract String getLogo();

  public abstract String getDescription();

  public abstract String getType();

}
