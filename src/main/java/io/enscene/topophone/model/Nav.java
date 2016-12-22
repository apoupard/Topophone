package io.enscene.topophone.model;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;

import java.util.List;

@AutoValue
public abstract class Nav implements ResourceModel {

  public static Nav of(List<NavEntry> entries) {
    return new AutoValue_Nav.Builder().entries(entries).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder entries(List<NavEntry> entries);

    public abstract Nav build();
  }

  public abstract List<NavEntry> getEntries();

}
