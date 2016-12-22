package io.enscene.topophone.model.accompanying;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Contact {

  public static Builder builder() {
    return new AutoValue_Contact.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder name(String name);

    public abstract Builder phone(String phone);

    public abstract Builder email(String email);

    public abstract Builder address(String address);

    public abstract Contact build();

  }

  public abstract String getName();

  public abstract String getPhone();

  public abstract String getEmail();

  public abstract String getAddress();

}
