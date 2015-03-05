package io.enscene.topophone.model.partner;

import io.enscene.topophone.api.ResourceModel;

import java.util.Collection;
import java.util.Map;

public class Partners implements ResourceModel {

//  private final Set<Institution> institutions = Sets.newHashSet();
//  private final Map<String, Collection<Partner>> partnerByInstitution = Maps.newHashMap();
  
  private final Map<Institution, Collection<Partner>> partnersByInstitution;

  public Partners(Map<Institution, Collection<Partner>> partnerByInstitution) {
    this.partnersByInstitution = partnerByInstitution;
//    institutions.addAll(partnerByInstitution.keySet());
//    partnerByInstitution.forEach((t, e) -> this.partnerByInstitution.put(t.getCode(), e));
  }

  public Map<Institution, Collection<Partner>> getPartnersByInstitution() {
    return partnersByInstitution;
  }

}
