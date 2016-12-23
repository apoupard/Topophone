package io.enscene.topophone.model.partner;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Value.Immutable
@JsonSerialize(as = ImmutablePartners.class)
@JsonDeserialize(as = ImmutablePartners.class)
public interface Partners extends ResourceModel {

  public static ImmutablePartners.Builder builder(Map<Institution, Collection<Partner>> partnersByInstitution, HeadbandCarousel headband) {
    return ImmutablePartners.builder();
  }

  HeadbandCarousel getHeadbandCarousel();
  
  List<PartnersByInstitution> getPartnersByInstitution();
  
  @Value.Immutable
  @JsonSerialize(as = ImmutablePartnersByInstitution.class)
  @JsonDeserialize(as = ImmutablePartnersByInstitution.class)
  public static interface PartnersByInstitution {
      
      Institution getInstitution();
      Collection<Partner> getPartners();
  
  }
  
}
