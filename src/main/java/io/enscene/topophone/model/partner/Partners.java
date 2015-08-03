package io.enscene.topophone.model.partner;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.Headband;

import java.util.Collection;
import java.util.Map;

public class Partners implements ResourceModel {

  private Map<Institution, Collection<Partner>> partnersByInstitution;
  
  private Headband headband;

  public Partners() {
  }
  
  public Partners(Map<Institution, Collection<Partner>> partnersByInstitution, Headband headband) {
    super();
    this.partnersByInstitution = partnersByInstitution;
    this.headband = headband;
  }


  
  public Map<Institution, Collection<Partner>> getPartnersByInstitution() {
    return partnersByInstitution;
  }

  public void setPartnersByInstitution(Map<Institution, Collection<Partner>> partnersByInstitution) {
    this.partnersByInstitution = partnersByInstitution;
  }

  public Headband getHeadband() {
    return headband;
  }

  public void setHeadband(Headband headband) {
    this.headband = headband;
  }
  
}
