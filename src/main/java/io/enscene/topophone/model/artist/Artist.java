package io.enscene.topophone.model.artist;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import io.enscene.topophone.api.ResourceModel;

import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_Artist.Builder.class)
public abstract class Artist implements ResourceModel {

    public static Builder builder() {
        return new AutoValue_Artist.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder id(String s);

        public abstract Builder picture(String n);

        public abstract Builder medias(List<Media> medias);

        public abstract Builder videos(List<Video> videos);

        public abstract Builder concerts(List<Concert> concerts);

        public abstract Builder songs(List<Song> songs);

        public abstract Builder description(String s);

        public abstract Builder headband(Headband s);

        public abstract Builder contactEmail(String s);

        public abstract Artist build();

    }

    public abstract String getid();

    public abstract String getPicture();

    public abstract List<Media> getMedias();

    public abstract List<Video> getVideos();

    public abstract List<Concert> getConcerts();

    public abstract List<Song> getSongs();

    public abstract String getDescription();

    public abstract Headband getHeadband();

    public abstract String getContactEmail();

}
