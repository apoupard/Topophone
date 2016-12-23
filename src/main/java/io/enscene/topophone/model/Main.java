package io.enscene.topophone.model;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Value.Immutable
@JsonSerialize(as = ImmutableMain.class)
@JsonDeserialize(as = ImmutableMain.class)
public interface Main extends ResourceModel {

  public static Main of(HeadbandCarousel headband, String description, Youtube videoLeft, Youtube videoRight) {
    return ImmutableMain.builder().headbandCarousel(headband).description(description).videoLeft(videoLeft).videoRight(videoRight).build();
  }

  HeadbandCarousel getHeadbandCarousel();

  String getDescription();

  Youtube getVideoLeft();

  Youtube getVideoRight();
  
}
