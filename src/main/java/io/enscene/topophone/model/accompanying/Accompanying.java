package io.enscene.topophone.model.accompanying;

import java.util.Collection;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Value.Immutable
@JsonSerialize(as = ImmutableAccompanying.class)
@JsonDeserialize(as = ImmutableAccompanying.class)
public interface Accompanying extends ResourceModel {

  public static Accompanying of(HeadbandCarousel headband, Collection<String> objectives, Contact contact, String description, String picture) {
    return ImmutableAccompanying.builder().headbandCarousel(headband).objectives(objectives).contact(contact).description(description).picture(picture).build();
  }

  HeadbandCarousel getHeadbandCarousel();

  Collection<String> getObjectives();

  Contact getContact();

  String getDescription();

  String getPicture();

}
