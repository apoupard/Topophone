package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Headband {

  public abstract String getMain();

  public abstract String getLogo();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder main(String main);

    public abstract Builder logo(String logo);

    public abstract Headband build();
  }

  public static Headband of(String main, String logo) {
    return new AutoValue_Headband.Builder().main(main).logo(logo).build();
  }
}
