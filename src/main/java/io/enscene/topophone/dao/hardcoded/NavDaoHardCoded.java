package io.enscene.topophone.dao.hardcoded;

import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.model.nav.Entry;
import io.enscene.topophone.model.nav.Nav;

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
        .add(Entry.smallSeparator())
        .add(Entry.of("partners", "partenaires", "/partners"))
        .add(Entry.smallSeparator())
        .add(educationSubMenu())
        .add(Entry.separator())
        .add(Entry.of("accompanying", "accompagnement", "/accompanying"))
        .add(Entry.smallSeparator())
        .add(artist())
        .add(Entry.smallSeparator())
        .build();
  }

  private Entry artist() {
    return Entry.of("artist", "artistes", "/artist", ImmutableList.of(Entry.of("lecommondiamond",
        "le common diamond", "/artist/lecommondiamond"), Entry.of("internationalhyperrythmique",
        "international hyper rythmique", "/artist/internationalhyperrythmique")));
  }

  private Entry educationSubMenu() {
    return Entry.of(
        "education",
        "actions éducatives",
        "/education",
        ImmutableList.of(Entry.of("creation", "Création musicale", "/education/creation"),
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
