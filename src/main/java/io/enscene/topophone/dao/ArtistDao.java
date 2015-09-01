package io.enscene.topophone.dao;

import io.enscene.topophone.model.artist.Artist;
import io.enscene.topophone.model.artist.Concert;
import io.enscene.topophone.model.artist.Headband;
import io.enscene.topophone.model.artist.Media;
import io.enscene.topophone.model.artist.Song;
import io.enscene.topophone.model.artist.Video;

import java.util.ArrayList;
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
    List<Concert> concerts =
        ImmutableList.of(new Concert(new GregorianCalendar(2015, 06, 11).getTime(), "Club liberté",
            "Helsinki"), new Concert(new GregorianCalendar(2015, 06, 12).getTime(), "Mbar",
            "Helsinki"));
    return new Artist(id, getProfileImage(id), getSocialMedia(id), getIhrSongs(), concerts, getDescription("artist",id),
        getHeadband(id), "contact@ihr.com", getVideos());
  }

  private List<Song> getIhrSongs() {
    List<Song> songs = new ArrayList<>();
    songs.add(new Song("Cowboy", "music/ihr/cowboy.wav"));
    songs.add(new Song("Marble giant", "music/ihr/marblegiant.wav"));
    songs.add(new Song("Norma jeane", "music/ihr/normajeane.wav"));
    return songs;
  }
  
  private List<Song> getleCommonDiamondSongs() {
    List<Song> songs = new ArrayList<>();
    songs.add(new Song("After All", "music/lecommondiamond/afterall.wav"));
    songs.add(new Song("Scandinavia", "music/lecommondiamond/scandinavia.wav"));
    songs.add(new Song("Swedish Summer Dream", "music/lecommondiamond/swedishsummerdream.wav"));
    songs.add(new Song("The Monster", "music/lecommondiamond/themonster.wav"));
    return songs;
  }

  private List<Video> getVideos() {
    return ImmutableList.of(
        new Video("RfswM1TKImw", "Clip \"AFTER ALL\"<br /> Common diamond<br /> Elliot Broué / 2010"), 
        new Video("l3kcrbm2aNc", ""), 
        new Video("AKCVIaO7JzA", ""), 
        new Video("2Y_Y1r6GxlE", "Clip \"le 1er clip\"<br /> Common diamond<br /> Elliot Broué / 2010"), 
        new Video("zqI8G4HFMqE", ""));
  }

  private String getProfileImage(String id) {
    return "/images/artists/" + id + "/profile.png";
  }

  private Headband getHeadband(String id) {
    return new Headband("/images/artists/" + id + "/bandeau.png", "/images/artists/" + id
        + "/bandeauLogo.png");
  }

  private Artist getLeCommonDiamond(String id) {
    List<Media> medias = getSocialMedia(id);
    List<Concert> concerts =
        ImmutableList.of(new Concert(new GregorianCalendar(2015, 06, 11).getTime(), "Club liberté",
            "Helsinki"), new Concert(new GregorianCalendar(2015, 06, 12).getTime(), "Mbar",
            "Helsinki"));
    return new Artist(id, getProfileImage(id), medias, getleCommonDiamondSongs(), concerts, getDescription("artist",id),
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
