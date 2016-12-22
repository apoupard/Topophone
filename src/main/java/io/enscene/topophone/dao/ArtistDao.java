package io.enscene.topophone.dao;

import com.google.common.collect.ImmutableList;
import io.enscene.topophone.model.artist.*;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Singleton
public class ArtistDao extends AstractHardCoded<Artist> {

  @Override
  void init(Map<String, Artist> database) {
    database.put("lecommondiamond", getLeCommonDiamond("lecommondiamond"));
    database.put("ihr", getInternationalHyperRythmique("ihr"));
  }

  private Artist getInternationalHyperRythmique(String id) {
    return Artist.builder()
        .id(id)
        .picture(getProfileImage(id))
        .medias(getIhrSocialMedia())
        .songs(getIhrSongs())
        .concerts(getIhrConcert())
        .description(getDescription("artist", id))
        .headband(getHeadband(id))
        .contactEmail("contact@ihr.com")
        .videos(getIhrVideos())
        .build();
  }

  private List<Song> getIhrSongs() {
    List<Song> songs = new ArrayList<>();
    songs.add(Song.of("Cowboy", "music/ihr/cowboy.wav"));
    songs.add(Song.of("Marble giant", "music/ihr/marblegiant.wav"));
    songs.add(Song.of("Norma jeane", "music/ihr/normajeane.wav"));
    return songs;
  }
  
  private List<Song> getleCommonDiamondSongs() {
    List<Song> songs = new ArrayList<>();
    songs.add(Song.of("After All", "music/lecommondiamond/afterall.wav"));
    songs.add(Song.of("Scandinavia", "music/lecommondiamond/scandinavia.wav"));
    songs.add(Song.of("Swedish Summer Dream", "music/lecommondiamond/swedishsummerdream.wav"));
    songs.add(Song.of("The Monster", "music/lecommondiamond/themonster.wav"));
    return songs;
  }

  private List<Video> getCommonDiamondVideos() {
    return ImmutableList.of(
        Video.of("RfswM1TKImw", "\"AFTER ALL\"", "Avril 2014", "Mix. A.Workman & A.Libeyre", "Real. Elliott Broué"),
        Video.of("l3kcrbm2aNc", "\"SCANDINAVIA\" ", "Octobre 2014", "Live @ Le Bikini", "Réal. Ypok"),
        Video.of("AKCVIaO7JzA", "\"KILL US TONIGHT\" ", "Avril 2015", "Live @ Le Printemps de Bourges", "Réal. Le Printemps de Bourges"),
        Video.of("2Y_Y1r6GxlE", "\"GO OUT FOR A WALK\" ", "Mai 2012", "Mix. Thom La Juv's", "Réal. Laureline Lavergne"));
  }

  private List<Video> getIhrVideos() {
    return ImmutableList.of(
        Video.of("Z5vk0QCY8zk", "\"COWBOYS\"", "Mars 2013", "", "Réal. P. Gilbert"),
        Video.of("QGP4n2mxln0", "\"NORMA JEAN\" ", "Mars 2014", "", "Réal. Mamy Scopitone "),
        Video.of("bGZvlud8lIE", "\"STONE AND DUST\" ", "Septembre 2014", "", "Réal. P. Gilbert"),
        Video.of("VJ3pbTeSIJI", "\"THE BOAT\" ", "Juin 2015", "Live @ Espace Bonnefoy", "Réal. Ypok"),
        Video.of("l7ocDe3Qleg", "\"COWBOYS\" ", "Juin 2015", "Live @ Espace Bonnefoy", " Réal. Ypok"));
  }
  
  private String getProfileImage(String id) {
    return "/images/artists/" + id + "/profile.png";
  }

  private Headband getHeadband(String id) {
    return Headband.of("/images/artists/" + id + "/bandeau.png", "/images/artists/" + id + "/bandeauLogo.png");
  }

  private Artist getLeCommonDiamond(String id) {
    List<Media> medias = getCommonDiamondSocialMedia();
    List<Concert> concerts =
        getCommonDiamondConcerts();

    return Artist.builder()
        .id(id)
        .picture(getProfileImage(id))
        .medias(medias)
        .songs(getleCommonDiamondSongs())
        .concerts(concerts)
        .description(getDescription("artist", id))
        .headband(getHeadband(id))
        .contactEmail("contact@lecommundiamond.com")
        .videos(getCommonDiamondVideos())
        .build();
  }

  private ImmutableList<Concert> getCommonDiamondConcerts() {
    return ImmutableList.of(
        Concert.of(6,9,2015,"Festival Toulouse d'Eté", "Toulouse - w/Fanel"),
        Concert.of(8,8,2015,"Festival Pause Guitare", "Albi - w/Bob Dylan"),
        Concert.of(25,5,2015,"Les Inouïs du Printemps de Bourges", "Bourges - w/Puts Marie"),
        Concert.of(9,5,2015,"Le Stereolux", "Nantes – w/Kid Wise"),
        Concert.of(21,4,2015,"Le Portail Coucou", "Salon de Provence"),
        Concert.of(13,4,2015,"MJC L'Escale", "Aubagne – w/Martin Mey"),
        Concert.of(5,4,2015,"Le Bouillon", "Orléans – w/Martin Mey"),
        Concert.of(4,4,2015,"Les 3 Baudets", "Paris"),
        Concert.of(29,12,2014,"Le Bus Palladium", "Paris – International Hyper Rythmique"),
        Concert.of(27,12,2014,"Le Connexion", "Toulouse – w/Isaac Delusion"),
        Concert.of(7,12,2014,"L'Escapade", "Hénin Beaumont – w/International Hyper Rythmique"),
        Concert.of(15,2,2014,"Le Bikini", "Ramonville Saint-Agne – w/Sébastien Tellier")
        );
  }
  
  private ImmutableList<Concert> getIhrConcert() {
    return ImmutableList.of(
        Concert.of(16,11,2015,"Les 3 Baudets", "Paris"), 
        Concert.of(28,7,2015,"La Dynamo", "Toulouse – w/Alpaga"), 
        Concert.of(8,5,2015,"Le Coeur de Boeuf", "Lons Le Saunier"), 
        Concert.of(17,2,2015,"Le Chapeau Rouge", "Carcassonne"), 
        Concert.of(29,12,2014,"Le Bus Palladium", "Paris – w/Le Common Diamond"), 
        Concert.of(25,12,2014,"Le Bikini", "Ramonville Saint-Agne – w/Emilie Simon"), 
        Concert.of(7,12,2014,"L'Escapade", "Hénin Beaumont – w/Le Common Diamond"), 
        Concert.of(04,12,2014,"L'Espace Bonnefoy", "Toulouse – w/The Telescopes"), 
        Concert.of(28,11,2014,"La Dynamo", "Toulouse – w/Sebadoh"), 
        Concert.of(2,9,2014,"Festival de Carcassonne", "Carcassonne – w/Kavinsky"), 
        Concert.of(5,8,2014,"Festival Les Brasseurs du Lac", "Villeneuve Tolosane"));
  }
  
  private List<Media> getIhrSocialMedia() {
    List<Media> medias =
        ImmutableList.of(Media.of("youtube", "https://www.youtube.com/channel/UC5180Stl_9dDHwyO5hwK-Jw"), Media.of(
            "facebook", "https://www.facebook.com/International-Hyper-Rythmique-37427384425/timeline/"), Media.of("bandcamp",
            "https://ihrmusic.bandcamp.com"));
    return medias;
  } 

  private List<Media> getCommonDiamondSocialMedia() {
    List<Media> medias =
        ImmutableList.of(Media.of("youtube", "https://www.youtube.com/user/LeCommonDiamond"), Media.of(
            "facebook", "https://www.facebook.com/LeCommonDiamond"), Media.of("bandcamp",
            "https://lecommondiamond.bandcamp.com/"));
    return medias;
  }

}
