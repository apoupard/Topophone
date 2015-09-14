package io.enscene.topophone.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

import io.enscene.topophone.model.artist.Artist;
import io.enscene.topophone.model.artist.Concert;
import io.enscene.topophone.model.artist.Headband;
import io.enscene.topophone.model.artist.Media;
import io.enscene.topophone.model.artist.Song;
import io.enscene.topophone.model.artist.Video;

@Singleton
public class ArtistDao extends AstractHardCoded<Artist> {

  @Override
  void init(Map<String, Artist> database) {
    database.put("lecommondiamond", getLeCommonDiamond("lecommondiamond"));
    database.put("ihr", getInternationalHyperRythmique("ihr"));
  }

  private Artist getInternationalHyperRythmique(String id) {
    List<Concert> concerts =
        getCommonDiamondConcerts();
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
        new Video("RfswM1TKImw", "\"AFTER ALL\""," Avril 2014 "," Mix. A.Workman & A.Libeyre "," Elliot Broué"), 
        new Video("l3kcrbm2aNc", "\"SCANDINAVIA\" "," Octobre 2014 "," Live @ Le Bikini "," Réal. Ypok"), 
        new Video("AKCVIaO7JzA", "\"KILL US TONIGHT\" "," Avril 2015 "," Live @ Le Printemps de Bourges "," Réal. Le Printemps de Bourges"), 
        new Video("2Y_Y1r6GxlE", "\"GO OUT FOR A WALK\" "," Mai 2012 "," Mix. Thom La Juv's "," Mix. Thom La Juv's"));
  }
  
  private String getProfileImage(String id) {
    return "/images/artists/" + id + "/profile.png";
  }

  private Headband getHeadband(String id) {
    return new Headband("/images/artists/" + id + "/bandeau.png", "/images/artists/" + id + "/bandeauLogo.png");
  }

  private Artist getLeCommonDiamond(String id) {
    List<Media> medias = getSocialMedia(id);
    List<Concert> concerts =
        getCommonDiamondConcerts();
    return new Artist(id, getProfileImage(id), medias, getleCommonDiamondSongs(), concerts, getDescription("artist",id),
        getHeadband(id), "contact@lecommundiamond.com", getVideos());
  }

  private ImmutableList<Concert> getCommonDiamondConcerts() {
    return ImmutableList.of(
        Concert.of(6,8,2015,"Festival Toulouse d'Eté", "Toulouse - w/Fanel"),
        Concert.of(8,7,2015,"Festival Pause Guitare", "Albi - w/Bob Dylan"),
        Concert.of(25,4,2015,"Les Inouïs du Printemps de Bourges", "Bourges"),
        Concert.of(9,04,2015,"Le Stereolux", "Nantes – w/Kid Wise"),
        Concert.of(21,3,2015,"Le Portail Coucou", "Salon de Provence"),
        Concert.of(13,3,2015,"MJC L'Escale", "Aubagne – w/Martin Mey"),
        Concert.of(5,3,2015,"Le Bouillon", "Orléans – w/Martin Mey"),
        Concert.of(4,3,2015,"Les 3 Baudets", "Paris"),
        Concert.of(29,11,2015,"Le Bus Palladium", "Paris – International Hyper Rythmique"),
        Concert.of(27,11,2015,"Le Connexion", "Toulouse – w/Isaac Delusion"),
        Concert.of(7,11,2015,"L'Escapade", "Hénin Beaumont – w/International Hyper Rythmique"),
        Concert.of(15,1,2015,"Le Bikini", "Ramonville Saint-Agne – w/Sébastien Tellier"),
        Concert.of(11,1,2015,"Le Festi'Val De Marne – JIMI", "Ivry sur Seine"));
  }
  
  private List<Media> getSocialMedia(String id) {
    List<Media> medias =
        ImmutableList.of(new Media("youtube", "http://www.youtube.com/" + id), new Media(
            "facebook", "http://www.facebook.com/" + id), new Media("bandcamp",
            "http://www.bandcamp.com/" + id));
    return medias;
  }

}
