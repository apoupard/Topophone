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
    database.put("presentation",
        new DevArtists("presentation",
            "<h1>Développements d'artistes</h1>"
            + "<h3>L'atelier</h3>"
            + "<p>Dans cet atelier, les participants découvrent et prennent part à toutes les étapes d’une création musicale. Ils sont alors confrontés aux différentes facettes du musicien : interpréter une mélodie (instruments, voix), créer l’accompagnement harmonique et/ou rythmique d’un morceau, se mettre en situation de scène… En fonction des formats d’intervention choisis, les ateliers poursuivent différentes finalités : interprétation d’un morceau, création d’un petit spectacle (concert, conte musical) ou enregistrement dans un studio professionnel.</p><h3>Objectifs généraux</h3><ul><li>Utiliser la musique comme un vecteur de partage, de respect et d’ouverture à l’autre</li> <li>Permettre aux participants de construire un projet en groupe </li> <li>Faire découvrir les esthétiques propres aux musiques actuelles (rock, jazz, musique du monde...)</li> <li>Utiliser la création musicale comme un outil de connaissances pluridisciplinaires (arts, français, histoire, géographie...)</li></ul>",
            "/images/education/creation.png", getHeadBand(), getArtistLinks()));
    database.put("appscenic",
        new DevArtists("appscenic",
            "<h1>Accompagnement scénique</h1> <h3>L'atelier</h3><p>Des musiciens professionnels interviennent en classe durant 1 à 2 heures. Sur la base d’un récit d’expérience suivi d’un concert « interactif », ce moment permet la rencontre, l’échange et le partage entre musiciens et jeune public.</p><h3>Objectifs généraux</h3><ul><li>Sensibiliser et ouvrir les élèves à la découverte musicale par la rencontre et l’échange avec des musiciens professionnels.</li><li>Utiliser la rencontre avec des artistes comme un vecteur de connaissances et d’enrichissement individuel</li></ul>",
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
