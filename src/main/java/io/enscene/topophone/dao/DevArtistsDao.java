package io.enscene.topophone.dao;

import com.google.common.collect.ImmutableList;
import io.enscene.topophone.model.DevArtists;
import io.enscene.topophone.model.DevArtists.ArtistLink;
import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
public class DevArtistsDao extends AstractHardCoded<DevArtists> {

  @Override
  void init(Map<String, DevArtists> database) {
    database.put("presentation", DevArtists.of("presentation", getDescription("devartists", "presentation"),
        "/images/education/creation.png", getHeadBand(), getSubNav("presentation"), getRightBlock("presentation"), getArtistLinks()));
    database.put("appscenic", DevArtists.of("appscenic", getDescription("devartists", "appscenic"),
        "/images/education/meeting.png", getHeadBand(), getSubNav("appscenic"), getRightBlock("appscenic"), "/images/devartists/mosaique.png"));
  }

  private List<ArtistLink> getArtistLinks() {
    return ImmutableList.of(
        ArtistLink.of("/images/devartists/lecommondiamond.jpg", "/artist/lecommondiamond"),
        ArtistLink.of("/images/devartists/ihr.jpg", "/artist/ihr"));
  }

  private HeadbandCarousel getHeadBand() {
    return HeadbandCarousel.of(getDevArtistsHeadbandImages(), "/images/education/headbandlogo.png");
  }

  private Nav getSubNav(String id) {
    List<NavEntry> entries = ImmutableList.of(
          NavEntry.of(id, "Développement d'artistes", "/devartists/presentation", "/devartists/presentation".contains(id)),
          NavEntry.of(id, "Accompagnement Scénique", "/devartists/appscenic", "/devartists/appscenic".contains(id))
        );
    return Nav.of(entries);
  }

  private String getRightBlock(String id) {
    return getEnginedTemplate("devartists","blockRight",id);
  }
}
