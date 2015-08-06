package io.enscene.topophone.dao;

import io.enscene.topophone.model.artist.Artist;
import io.enscene.topophone.model.artist.Concert;
import io.enscene.topophone.model.artist.Headband;
import io.enscene.topophone.model.artist.Media;
import io.enscene.topophone.model.artist.Song;
import io.enscene.topophone.model.artist.Video;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

@Singleton
public class ArtistDao extends AstractHardCoded<Artist> {

  @Override
  void init(Map<String, Artist> database) {
    database.put("lecommondiamond", getLeCommonDiamond("lecommondiamond"));
    database.put("ihr", getInternationalHyperRythmique("ihr"));
  }

  private Artist getInternationalHyperRythmique(String id) {
    Song song = new Song("Cowboy", "4:03");
    List<Concert> concerts =
        ImmutableList.of(new Concert(new GregorianCalendar(2015, 06, 11).getTime(), "Club liberté",
            "Helsinki"), new Concert(new GregorianCalendar(2015, 06, 12).getTime(), "Mbar",
            "Helsinki"));
    return new Artist(getProfileImage(id), getSocialMedia(id), song, concerts, getDescription("artist",id),
        getHeadband(id), "contact@ihr.com", getVideos());
  }

  private List<Video> getVideos() {
    return ImmutableList.of(new Video("2Y_Y1r6GxlE","/images/artists/lecommondiamond/video1.png",
        "Clip \"le 1er clip\"<br /> Common diamond<br /> Elliot Broué / 2010"), new Video("RfswM1TKImw","/images/artists/lecommondiamond/video2.png",
        "Clip \"AFTER ALL\"<br /> Common diamond<br /> Elliot Broué / 2010"));
  }

  private String getProfileImage(String id) {
    return "/images/artists/" + id + "/profile.png";
  }

  private Headband getHeadband(String id) {
    return new Headband("/images/artists/" + id + "/bandeau.jpg", "/images/artists/" + id
        + "/bandeauLogo.png");
  }

  private Artist getLeCommonDiamond(String id) {
    List<Media> medias = getSocialMedia(id);
    Song song = new Song("Go faster", "3:52");
    List<Concert> concerts =
        ImmutableList.of(new Concert(new GregorianCalendar(2015, 06, 11).getTime(), "Club liberté",
            "Helsinki"), new Concert(new GregorianCalendar(2015, 06, 12).getTime(), "Mbar",
            "Helsinki"));
    return new Artist(getProfileImage(id), medias, song, concerts, getDescription("artist",id),
        getHeadband(id), "contact@lecommundiamond.com", getVideos());
  }

  private List<Media> getSocialMedia(String id) {
    List<Media> medias =
        ImmutableList.of(new Media("youtube", "http://www.youtube.com/" + id), new Media(
            "facebook", "http://www.facebook.com/" + id), new Media("bandcamp",
            "http://www.bandcamp.com/" + id));
    return medias;
  }

  
  

}
