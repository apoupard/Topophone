package io.enscene.topophone.widget.dao.hardcoded;

import io.enscene.topophone.widget.dao.NavDao;
import io.enscene.topophone.widget.model.nav.Entry;
import io.enscene.topophone.widget.model.nav.Nav;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.ImmutableList;

@Singleton
public class NavDaoHardCoded implements NavDao {

  final Nav nav;

  @Inject NavDaoHardCoded() {
    this.nav = new Nav(entries());
  }


  private List<Entry> entries() {
    return ImmutableList.<Entry>builder()
        .add(Entry.of("accompanying", "accompagnement", "/accompanying")).add(educationSubMenu())
        .add(Entry.separator()).add(artist()).add(Entry.of("partners", "partenaires", "/partners"))
        .build();
  }

  private Entry artist() {
    return Entry.of("artist", "Artistes", "/artist", ImmutableList.of(Entry.of("lecommondiamond",
        "le common diamond", "/artist/lecommondiamond"), Entry.of("internationalhyperrythmique",
        "international hyper rythmique", "/artist/internationalhyperrythmique")));
  }

  private Entry educationSubMenu() {
    return Entry.of(
        "education",
        "Actions éducative",
        "/education",
        ImmutableList.of(Entry.of("creation", "Création musicale", "/education/creation"),
            Entry.of("initiation", "Initiation à l'écoute", "/education/initiation"),
            Entry.of("meeting", "Rencontre d'artistes", "/education/meeting")));
  }


  @Override
  public Optional<Entry> get(String id, Optional<String> optional) {
    for(Entry entry : entries()) {
      if(StringUtils.equals(id, entry.getId())) {
        return Optional.of(entry);
      };
    }
    return Optional.empty();
  }


  @Override
  public Collection<Entry> getAll(Optional<String> optional) {
    return nav.getEntries();
  }

}
