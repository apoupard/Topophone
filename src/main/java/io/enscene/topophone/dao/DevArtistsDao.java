package io.enscene.topophone.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import freemarker.template.TemplateException;
import io.enscene.topophone.model.DevArtists;
import io.enscene.topophone.model.DevArtists.ArtistLink;
import io.enscene.topophone.model.artist.Headband;
import io.enscene.topophone.templating.HtmlTemplateEngine;

@Singleton
public class DevArtistsDao extends AstractHardCoded<DevArtists> {

//  private final HtmlTemplateEngine engine;

//  @Inject
//  public DevArtistsDao(HtmlTemplateEngine engine) {
//    this.engine = engine;
//  }

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
