package io.enscene.topophone.model.partner;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Institution {

  public static Institution of(String code, String displayName) {
    return new AutoValue_Institution.Builder().code(code).displayName(displayName).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder code(String code);

    public abstract Builder displayName(String displayName);

    public abstract Institution build();
  }

  public abstract String getCode();

  public abstract String getDisplayName();

}
