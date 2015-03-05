package io.enscene.topophone.model.partner;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;

public class InstitutionTest {
  
  @Test
  public void testEqual() {
    Institution inst1 = new Institution("code1", "name1");
    Assertions.assertThat(inst1).isEqualTo(inst1);
  }
  
  @Test
  public void testEqualSame() {
    Institution inst1 = new Institution("code1", "name1");
    Institution same = new Institution("code1", "name1");
    
    Assertions.assertThat(inst1).isEqualTo(same);
  }
  
  @Test
  public void testEqualSameCode() {
    Institution inst1 = new Institution("code1", "name1");
    Institution same = new Institution("code1", "name2");
    
    Assertions.assertThat(inst1).isEqualTo(same);
  }
  
  @Test
  public void testHashCode() {
    Institution inst1 = new Institution("code1", "name1");
    Assertions.assertThat(inst1.hashCode()).isEqualTo(inst1.hashCode());
  }
  
  @Test
  public void testHashCodeSame() {
    Institution inst1 = new Institution("code1", "name1");
    Institution same = new Institution("code1", "name1");
    
    Assertions.assertThat(inst1.hashCode()).isEqualTo(same.hashCode());
  }
  
  @Test
  public void testHashCodeSameCode() {
    Institution inst1 = new Institution("code1", "name1");
    Institution same = new Institution("code1", "name2");
    
    Assertions.assertThat(inst1.hashCode()).isEqualTo(same.hashCode());
  }
  
  
  @Test
  public void testHashMap() {
    Institution inst1 = new Institution("code1", "name1");
    ImmutableMap<Institution,Collection<Partner>> partners = ImmutableMultimap.<Institution, Partner>builder()
        .put(inst1, new Partner("t1", "logo1", "description1"))
        .put(inst1, new Partner("t2", "logo2", "description2"))
        .build().asMap();
    Assertions.assertThat(partners.get(inst1)).hasSize(2);
  }

}
