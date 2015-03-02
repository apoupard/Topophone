package io.enscene.topophone.dao.hardcoded;

import io.enscene.topophone.dao.ArtistDao;
import io.enscene.topophone.model.artist.Artist;
import io.enscene.topophone.model.artist.Concert;
import io.enscene.topophone.model.artist.Headband;
import io.enscene.topophone.model.artist.Media;
import io.enscene.topophone.model.artist.Song;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

@Singleton
public class ArtistDaoHardCoded extends AstractHardCoded<Artist> implements ArtistDao {

  @Override
  void init(Map<String, Artist> database) {
    database.put("lecommondiamond", getLeCommonDiamond("lecommondiamond"));
  }
  
  private Artist getLeCommonDiamond(String id){
    List<Media> medias =ImmutableList.of(
        new Media("youtube", "http://www.youtube.com/"+id), 
        new Media("facebook","http://www.facebook.com/"+id), 
        new Media("bandcamp", "http://www.bandcamp.com/"+id));
    Song song = new Song("Go faster", "3:52");
    List<Concert> concerts = ImmutableList.of(
        new Concert(new GregorianCalendar(2015, 06, 11).getTime(), "Club liberté", "Helsinki"),
        new Concert(new GregorianCalendar(2015, 06, 12).getTime(), "Mbar", "Helsinki")
     );
    return new Artist("/images/"+id+".png", medias, song,concerts, getDescription(), getHeadband(), getContactEmail());
  }

  
  public String getDescription() {
    return "<h3>Bio</h3>"+
        "<div class=\"block\">Floran et Thomas puisent dans le solaire et"+
        "    l’abyssal pour délivrer un subtil cocktail de chansons reflétant leurs"+
        "    pensées inondées de beautés féminines, de sentiments non maitrisés, de"+
        "    frustration, de rêves d’idéaux et d’envies de voyages.</div>"+
        "<div class=\"block\">Le Common Diamond est armé d’une musique"+
        "    cérébrale et cardiaque, mêlant pop, minimalisme électronique et grands"+
        "    espaces : de la space-pop . Le beat est froid, la guitare chaude, les"+
        "    synthés vibrants, et les voix transcendent au service des chansons. Le"+
        "    couple s’inspire mais ne réchauffe pas.</div>"+
        "<h3>Ils en parlent</h3>"+
        "<div class=\"block\">"+
        "    <span class=\"GDPD4GNPJ\">Madame Le Figaro</span>"+
        "    <p>“Deux Toulousains aux envolées surf-pop qui sentent bon l’été"+
        "        sur la ecôte Atlantique”</p>"+
        "    <span class=\"GDPD4GNPJ\">Listen Before You Buy</span>"+
        "    <p>“The moodiness of Air, the sexuality of Sébastien Tellier”</p>"+
        "</div>";
  }
  
  public Headband getHeadband() {
    return new Headband("/images/bandeau.png", "/images/bandeauLogo.png");
  }
  
  public String getContactEmail() {
    return "contact@lecommundiamond.com";
  }
  
}
