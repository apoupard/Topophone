package io.enscene.topophone.dao;

import java.util.Map;

import io.enscene.topophone.model.Contacts;
import io.enscene.topophone.model.artist.Headband;

public class ContactsDao extends AstractHardCoded<Contacts> {

  @Override
  void init(Map<String, Contacts> database) {
    database.put("1", new Contacts(new Headband("/images/education/headband.png", "/images/education/headbandlogo.png")));
  }

}
