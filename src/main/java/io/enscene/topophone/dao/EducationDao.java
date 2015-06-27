package io.enscene.topophone.dao;

import io.enscene.topophone.model.Education;
import io.enscene.topophone.model.artist.Headband;

import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class EducationDao extends AstractHardCoded<Education> {

  @Override
  void init(Map<String, Education> database) {
    database
        .put(
            "creation",
            new Education(
                "creation",
                "/images/education/educationImageLeft.png",
                "<h1>Création musicale</h1><h3>L'atelier</h3><p>Dans cet atelier, les participants découvrent et prennent part à toutes les étapes d’une création musicale. Ils sont alors confrontés aux différentes facettes du musicien : interpréter une mélodie (instruments, voix), créer l’accompagnement harmonique et/ou rythmique d’un morceau, se mettre en situation de scène… En fonction des formats d’intervention choisis, les ateliers poursuivent différentes finalités : interprétation d’un morceau, création d’un petit spectacle (concert, conte musical) ou enregistrement dans un studio professionnel.</p><h3>Objectifs généraux</h3><ul><li>Utiliser la musique comme un vecteur de partage, de respect et d’ouverture à l’autre</li> <li>Permettre aux participants de construire un projet en groupe </li> <li>Faire découvrir les esthétiques propres aux musiques actuelles (rock, jazz, musique du monde...)</li> <li>Utiliser la création musicale comme un outil de connaissances pluridisciplinaires (arts, français, histoire, géographie...)</li></ul>",
                "/images/education/creation.png", getHeadBand()));
    database
        .put(
            "meeting",
            new Education(
                "meeting",
                "/images/education/educationImageLeft.png",
                "<h1>Rencontre d’artistes</h1> <h3>L'atelier</h3><p>Des musiciens professionnels interviennent en classe durant 1 à 2 heures. Sur la base d’un récit d’expérience suivi d’un concert « interactif », ce moment permet la rencontre, l’échange et le partage entre musiciens et jeune public.</p><h3>Objectifs généraux</h3><ul><li>Sensibiliser et ouvrir les élèves à la découverte musicale par la rencontre et l’échange avec des musiciens professionnels.</li><li>Utiliser la rencontre avec des artistes comme un vecteur de connaissances et d’enrichissement individuel</li></ul>",
                "/images/education/meeting.png", getHeadBand()));
  }

  private Headband getHeadBand() {
    return new Headband("/images/education/headband.png", "/images/education/headbandlogo.png");
  }
}