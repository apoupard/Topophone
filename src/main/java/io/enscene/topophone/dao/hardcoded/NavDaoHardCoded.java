package io.enscene.topophone.dao.hardcoded;

import io.enscene.topophone.dao.NavDao;
import io.enscene.topophone.model.nav.Entry;
import io.enscene.topophone.model.nav.Nav;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

@Singleton
public class NavDaoHardCoded extends AstractHardCoded<Nav> implements NavDao {

  @Override
  void init(Map<String, Nav> database) {
    database.put("1", new Nav(entries()));
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

}
