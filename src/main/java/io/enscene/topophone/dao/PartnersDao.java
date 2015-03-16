package io.enscene.topophone.dao;

import io.enscene.topophone.model.partner.Institution;
import io.enscene.topophone.model.partner.Partner;
import io.enscene.topophone.model.partner.Partners;

import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

@Singleton
public class PartnersDao extends AstractHardCoded<Partners> {

  @Override
  void init(Map<String, Partners> database) {
    Multimap<Institution, Partner> partners = getPartners();
    database.put("1", new Partners(partners.asMap()));
  }

  private Multimap<Institution, Partner> getPartners() {
    Institution institutionnels = new Institution("institutionnels", "Institutionnels");
    Institution prives = new Institution("prives", "Privés");
    Institution associatifs = new Institution("associatifs", "Associatifs");
    
    return ImmutableMultimap.<Institution, Partner>builder()
            .put(
                institutionnels,
                new Partner(
                    "Institutionnels",
                    "/images/partners/fse.png",
                    "<span class=\"bold\">Le fonds social européen</span> (FSE) est l'un des fonds structurels de l'Union européenne. Il contribue à l'objectif \"Compétitivité régionale et emploi\" de la politique de cohésion de l'Union européenne. <br> Le FSE soutient Topophone sur les actions en CLAE et en entreprises."))
            .put(
                institutionnels,
                new Partner(
                    "Institutionnels",
                    "/images/partners/peja.png",
                    "Le <span class=\"bold\">programme Européen jeunesse en action</span> apporte une aide financière et pédagogique aux projets initiés et réalisés par les groupes de jeunes de 15-30 ans. L'objectif est de soutenir la prise d’initiative des jeunes, de développer l’esprit d’entreprise et la créativité des jeunes. Le PEJA apporte un soutien à l'association sur le développement des actions éducatives en école."))
            .put(
                institutionnels,
                new Partner(
                    "Privés",
                    "/images/partners/producson.png",
                    "Fondé en 1994, <span class=\"bold\">Produc’son</span> est un studio d’enregistrement et de répétition indépendant pour les particuliers et les professionnels. <br> Il accompagne nos artistes lors de l’enregistrement de morceaux. <br> Cyril Château, gérant du studio, accueille également des groupes de jeunes auprès desquels Topophone intervient afin de leur faire découvrir le lieu et d’enregistrer les morceaux qu’ils ont créé lors des ateliers éducatifs."))
            .put(
                prives,
                new Partner(
                    "Privés",
                    "/images/partners/gandi.png",
                    "<span class=\"bold\">Gandi</span> SAS est une société française d'enregistrement de noms de domaine et hébergeur web. <br> Elle constitue une alternative crédible pour tous ceux qui veulent être présents sur le Web. A ce titre, Gandi apporte un coup de pouce à Topophone pour la mise en place et le lancement de son site internet."))
            .put(
                prives,
                new Partner(
                    "Associatifs",
                    "/images/partners/mlep.png",
                    "Mouvement laïque d'éducation populaire, <span class=\"bold\">la Ligue de l'Enseignement</span> est une fédération regroupant diverses associations adhérentes. Topophone est affilié à la Ligue de l’Enseignement 31 et bénéficie, outre les services proposés à tout adhérent (formations, rencontres…) d’un accompagnement individualisé sur la partie « actions éducatives » (réunions de travail, mise en relation avec des structures péri et extra scolaires…)."))
            .put(
                associatifs,
                new Partner(
                    "Associatifs",
                    "/images/partners/microphages.png",
                    "<span class=\"bold\">Les Musicophages</span> , est un centre de ressources des Musiques Actuelles. Topophone est suivi par les Musicophages dans le cadre de leur action « pépinière et accompagnement de projets » au travers de réunions hebdomadaires individuelles, et encadrées par des professionnels (producteur artistique, directeur de centre de loisirs, webmaster, documentaliste)."))
            .put(
                associatifs,
                new Partner(
                    "Associatifs",
                    "/images/partners/bestiaire.png",
                    "<span class=\"bold\">Le Bestiaire</span> est une association de « création et production d'événements culturels et divertissants dans un univers articulé autour de ses espèces artistiques protégées dans le but de mélanger les genres et les gens. » Le Bestiaire apporte une aide utile à Topophone sur toutes les questions relatives au contexte des Musiques Actuelles (cadre juridique et économique, réseaux…)."))
            .put(
                associatifs,
                new Partner(
                    "Associatifs",
                    "/images/partners/franceactive.png",
                    "<span class=\"bold\">France Active</span> est un réseau de proximité qui aide les personnes en difficulté et finance les entreprises solidaires (insertion par l’activité économique, associations d’utilité sociale).\" Topophone est accompagné par Midi-Pyrénées Active au titre du \"Contrat d’amorçage associatif\", qui a pour objectif de proposer aux petites associations en création une première marche vers la structuration financière."))
            .build();
  }

}
