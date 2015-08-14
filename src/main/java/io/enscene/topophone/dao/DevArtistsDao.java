package io.enscene.topophone.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

import io.enscene.topophone.model.DevArtists;
import io.enscene.topophone.model.DevArtists.ArtistLink;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;
import io.enscene.topophone.model.artist.HeadbandCarousel;

@Singleton
public class DevArtistsDao extends AstractHardCoded<DevArtists> {

  @Override
  void init(Map<String, DevArtists> database) {
    database.put("presentation", new DevArtists("presentation", getDescription("devartists","presentation"),
        "/images/education/creation.png", getHeadBand(), getArtistLinks(), getSubNav("presentation")));
    database.put("appscenic", new DevArtists("appscenic", getDescription("devartists","appscenic"),
        "/images/education/meeting.png", getHeadBand(), getArtistLinks(), getSubNav("appscenic")));
  }

  private List<ArtistLink> getArtistLinks() {
    return ImmutableList.of(
        new ArtistLink("/images/devartists/lecommondiamond.jpg", "/artist/lecommondiamond"),
        new ArtistLink("/images/devartists/ihr.jpg", "/artist/ihr"));
  }

  private HeadbandCarousel getHeadBand() {
    return new HeadbandCarousel(getDevArtistsHeadbandImages(), "/images/education/headbandlogo.png");
  }

  private Nav getSubNav(String id) {
    List<NavEntry> entries = ImmutableList.of(
          NavEntry.of(id, "Développements d'artistes", "/devartists/presentation", "/devartists/presentation".contains(id)),
          NavEntry.of(id, "Accompagnement scéniques", "/devartists/appscenic", "/devartists/appscenic".contains(id))
        );
    return new Nav(entries);
  }
 

}
