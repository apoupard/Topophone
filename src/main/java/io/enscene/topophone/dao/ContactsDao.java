package io.enscene.topophone.dao;

import io.enscene.topophone.model.Contacts;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import java.util.Map;

public class ContactsDao extends AstractHardCoded<Contacts> {

  @Override
  void init(Map<String, Contacts> database) {
    database.put("1", Contacts.of(HeadbandCarousel.of(getAllHeadbandImages(), "/images/education/headbandlogo.png")));
  }

}
