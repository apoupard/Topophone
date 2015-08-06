package io.enscene.topophone.dao;

import io.enscene.topophone.model.accompanying.Accompanying;
import io.enscene.topophone.model.accompanying.Contact;
import io.enscene.topophone.model.artist.HeadbandCarousel;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ImmutableList;

public class AccompanyingDao extends AstractHardCoded<Accompanying> {

  @Override
  void init(Map<String, Accompanying> database) {
    database.put("1", new Accompanying(getHeadBand(), getObjective(), getContact(),
        getDescription(), getPicture()));
  }



  private HeadbandCarousel getHeadBand() {
    return new HeadbandCarousel(getDevArtistsHeadbandImages(),
        "/images/accompanying/headbandlogo.png");
  }

  private String getPicture() {
    return "/images/accompanying/topophonealaplage.png";
  }

  private String getDescription() {
    return new StringBuilder()
        .append("<h3>L'association</h3>")
        .append(
            "<p>Topophone est une association toulousaine qui promeut une musique basée sur l'échange et l'ouverture à l'autre.</p>")
        .append(
            "<p>En parallèle, elle mobilise ses artistes pour la réalisation d'action culturelles et éducatives auprès de stuctures scolaires et périscolaire notamment situées en zones prioritaires.</p>")
        .append("<h3>Les valeurs</h3>")
        .append(
            "<p>Principe de solidarité<br/>Topophone promeut et diffuse une musique basée sur des valeurs de partage, d'échange et d'ouverture à l'autre. Elle crée par se démarche un lien de soldarité entre artistes, les partenaires de l'associationet les jeunes bénéficiares des actions éducatives.</p>")
        .append(
            "<p>Les artistes porteurs de la démarche Topophone<br>Les groupes accompagnés par l'association s'inscivent dans la démarche \"citoyenne\". L'artiste n'est pas simple bénéficiare d'un projet car il partage son expérience auprès des jeunes.</p>")
        .append(
            "<p>Des partenaires solidaires<br/>les groupes bénéficient de l'engagement des partenaires Topophone.<br/>Ces derniers, dans leurs champs de compétences, facilitent le développement artistique des groupes accompagnés.</p>")
        .toString();
  }


  private Contact getContact() {
    return new Contact().setName("Sebastien BENAZET").setPhone("0612121212")
        .setEmail("association.topophone@gmail.com")
        .setAddress("TOPOPHONE<br>45 allé truc ezjiofjooij");
  }

  private Collection<String> getObjective() {
    return ImmutableList
        .of("Professionnaliser le projet musical des groupes",
            "Utiliser la musique comme support éducatif et pédagogique",
            "Sensibiliser et mobilisier les artistes sur le mise en place d'actions de médiations culturelles");
  }

}
