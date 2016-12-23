package io.enscene.topophone.model;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Value.Immutable
@JsonSerialize(as = ImmutableContacts.class)
@JsonDeserialize(as = ImmutableContacts.class)
public interface Contacts extends ResourceModel {

    public static ImmutableContacts.Builder builder() {
        return ImmutableContacts.builder();
    }

    HeadbandCarousel getHeadbandCarousel();

}
