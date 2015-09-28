package io.enscene.topophone.dao;

import io.enscene.topophone.model.Nav;
import io.enscene.topophone.model.NavEntry;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

@Singleton
public class NavDao extends AstractHardCoded<Nav> {

  @Override
  void init(Map<String, Nav> database) {
    database.put("1", new Nav(entries()));
  }


  private List<NavEntry> entries() {

    return ImmutableList.<NavEntry>builder()
        .add(NavEntry.smallSeparator())
        .add(artist())
        .add(NavEntry.separator())
        .add(educationSubMenu())
        .add(NavEntry.smallSeparator())
        .build();
  }

  private NavEntry artist() {
    return NavEntry.of("artist", "Développement d'Artistes",
        ImmutableList.of(
            NavEntry.of("presentation", "Présentation du Projet", "/devartists/presentation"),
            NavEntry.of("lecommondiamond", "Le Common Diamond", "/artist/lecommondiamond"),
            NavEntry.of("ihr", "International Hyper Rythmique", "/artist/ihr")));
  }

  private NavEntry educationSubMenu() {
    return NavEntry.of("education", "Actions Éducatives",
        ImmutableList.of(
            NavEntry.of("presentation", "Présentation du Projet", "/education/presentation"),
            NavEntry.of("creation", "Création Musicale", "/education/creation"),
            NavEntry.of("meeting", "L'Évenement des Apprentis-Musiciens", "/education/meeting")));
  }

}
