package io.enscene.topophone.model.artist;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.enscene.topophone.api.ResourceModel;

@Value.Immutable
@JsonSerialize(as = ImmutableArtist.class)
@JsonDeserialize(as = ImmutableArtist.class)
public interface Artist extends ResourceModel {

    public static ImmutableArtist.Builder builder() {
        return ImmutableArtist.builder();
    }

    String getId();

    String getPicture();

    List<Media> getMedias();

    List<Video> getVideos();

    List<Concert> getConcerts();

    List<Song> getSongs();

    String getDescription();

    Headband getHeadband();

    String getContactEmail();

}
