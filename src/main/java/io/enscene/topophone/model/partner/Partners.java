package io.enscene.topophone.model.partner;

import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import java.util.Collection;
import java.util.Map;

@AutoValue
public abstract class Partners implements ResourceModel {

  public static Partners of(Map<Institution, Collection<Partner>> partnersByInstitution, HeadbandCarousel headband) {
    return new AutoValue_Partners.Builder().headbandCarousel(headband).partnersByInstitution(partnersByInstitution).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder partnersByInstitution(Map<Institution, Collection<Partner>> partnersByInstitution);

    public abstract Builder headbandCarousel(HeadbandCarousel headband);

    public abstract Partners build();
  }

  public abstract Map<Institution, Collection<Partner>> getPartnersByInstitution();

  public abstract HeadbandCarousel getHeadbandCarousel();

}
