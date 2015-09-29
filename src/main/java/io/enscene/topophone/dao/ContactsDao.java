package io.enscene.topophone.dao;

import java.util.Map;

import io.enscene.topophone.model.Contacts;
import io.enscene.topophone.model.artist.HeadbandCarousel;

public class ContactsDao extends AstractHardCoded<Contacts> {

  @Override
  void init(Map<String, Contacts> database) {
    database.put("1", new Contacts(new HeadbandCarousel(getAllHeadbandImages(), "/images/education/headbandlogo.png")));
  }

}
