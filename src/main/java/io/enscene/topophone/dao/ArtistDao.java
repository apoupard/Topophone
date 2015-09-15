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
    return new Artist(id, getProfileImage(id), getSocialMedia(id), getIhrSongs(), getIhrConcert(), getDescription("artist",id),
        getHeadband(id), "contact@ihr.com", getIhrVideos());
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

  private List<Video> getCommonDiamondVideos() {
    return ImmutableList.of(
        new Video("RfswM1TKImw", "\"AFTER ALL\""," Avril 2014 "," Mix. A.Workman & A.Libeyre "," Elliot Broué"), 
        new Video("l3kcrbm2aNc", "\"SCANDINAVIA\" "," Octobre 2014 "," Live @ Le Bikini "," Réal. Ypok"), 
        new Video("AKCVIaO7JzA", "\"KILL US TONIGHT\" "," Avril 2015 "," Live @ Le Printemps de Bourges "," Réal. Le Printemps de Bourges"), 
        new Video("2Y_Y1r6GxlE", "\"GO OUT FOR A WALK\" "," Mai 2012 "," Mix. Thom La Juv's "," Mix. Thom La Juv's"));
  }
  
  private List<Video> getIhrVideos() {
    return ImmutableList.of(
        new Video("Z5vk0QCY8zk", "\"COWBOYS\"","Mars 2013","","Réal. P. Gilbert"), 
        new Video("QGP4n2mxln0", "\"NORMA JEAN\" ","Mars 2014","","Réal. Mamy Scopitone "), 
        new Video("bGZvlud8lIE", "\"STONE AND DUST\" ","Septembre 2014","","Réal. P. Gilbert"), 
        new Video("VJ3pbTeSIJI", "\"THE BOAT\" ","Juin 2015","Live @ Espace Bonnefoy","Réal. Ypok"), 
        new Video("l7ocDe3Qleg", "\"COWBOYS\" ","Juin 2015","Live @ Espace Bonnefoy"," Réal. Ypok"));
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
        getHeadband(id), "contact@lecommundiamond.com", getCommonDiamondVideos());
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
  
  private ImmutableList<Concert> getIhrConcert() {
    return ImmutableList.of(
        Concert.of(16,11,2015,"Les 3 Baudets", "Paris"), 
        Concert.of(28,6,2015,"La Dynamo", "Toulouse – w/Alpaga"), 
        Concert.of(8,4,2015,"Le Coeur de Boeuf", "Lons Le Saunier"), 
        Concert.of(17,1,2015,"Le Chapeau Rouge", "Carcassonne"), 
        Concert.of(29,11,2014,"Le Bus Palladium", "Paris – w/Le Common Diamond"), 
        Concert.of(25,11,2014,"Le Bikini", "Ramonville Saint-Agne – w/Emilie Simon"), 
        Concert.of(7,11,2014,"L'Escapade", "Hénin Beaumont – w/Le Common Diamond"), 
        Concert.of(04,11,2014,"L'Espace Bonnefoy", "Toulouse – w/The Telescopes"), 
        Concert.of(28,10,2014,"La Dynamo", "Toulouse – w/Sebadoh"), 
        Concert.of(11,10,2014,"Celtic Pub", "Tarbes"), 
        Concert.of(2,8,2014,"Festival de Carcassonne", "Carcassonne – w/Kavinsky"), 
        Concert.of(5,07,2014,"Festival Les Brasseurs du Lac", "Villeneuve Tolosane"));
  }
  

  
  private List<Media> getSocialMedia(String id) {
    List<Media> medias =
        ImmutableList.of(new Media("youtube", "http://www.youtube.com/" + id), new Media(
            "facebook", "http://www.facebook.com/" + id), new Media("bandcamp",
            "http://www.bandcamp.com/" + id));
    return medias;
  }

}
