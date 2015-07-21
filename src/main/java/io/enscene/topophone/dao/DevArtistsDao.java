package io.enscene.topophone.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

import io.enscene.topophone.model.DevArtists;
import io.enscene.topophone.model.DevArtists.ArtistLink;
import io.enscene.topophone.model.artist.Headband;

@Singleton
public class DevArtistsDao extends AstractHardCoded<DevArtists> {

  @Override
  void init(Map<String, DevArtists> database) {
    database.put("presentation", new DevArtists("presentation", getDescription("devartists","presentation"),
        "/images/education/creation.png", getHeadBand(), getArtistLinks()));
    database.put("appscenic", new DevArtists("appscenic", getDescription("devartists","appscenic"),
        "/images/education/meeting.png", getHeadBand(), getArtistLinks()));
  }

  private List<ArtistLink> getArtistLinks() {
    return ImmutableList.of(
        new ArtistLink("/images/devartists/lecommondiamond.jpg", "/artist/lecommondiamond"),
        new ArtistLink("/images/devartists/ihr.jpg", "/artist/ihr"));
  }

  private Headband getHeadBand() {
    return new Headband("/images/education/headband.png", "/images/education/headbandlogo.png");
  }
}
