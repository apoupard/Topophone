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
                getDescription("education", "creation"),
                "/images/education/creation.png", getHeadBand()));
    database
        .put(
            "meeting",
            new Education(
                "meeting",
                "/images/education/educationImageLeft.png",
                getDescription("education", "meeting"),
                "/images/education/meeting.png", getHeadBand()));
    database
    .put(
        "presentation",
        new Education(
            "presentation",
            "/images/education/educationImageLeft.png",
            getDescription("education", "presentation"),
            "/images/education/meeting.png", getHeadBand()));
  }

  private Headband getHeadBand() {
    return new Headband("/images/education/headband.png", "/images/education/headbandlogo.png");
  }
}
