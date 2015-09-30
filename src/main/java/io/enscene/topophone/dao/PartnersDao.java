package io.enscene.topophone.dao;

import io.enscene.topophone.model.artist.HeadbandCarousel;
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
    database.put("1", new Partners(partners.asMap(),
        new HeadbandCarousel(getAllHeadbandImages(), "/images/education/headbandlogo.png")));
  }

  private Multimap<Institution, Partner> getPartners() {
    Institution financiers = new Institution("financiers", "Financiers");
    Institution operationnels = new Institution("operationnels", "Opérationnels");

    return ImmutableMultimap.<Institution, Partner>builder().
        put(financiers, new Partner(
            "Financiers", "/images/partners/mairieToulouse.png",
            "La Marie de Toulouse soutient l'association Topophone au titre du dispositif du « Passeport pour l'Art ». "
                + "Elle met également à disposition de Topophone la salle de concert « Le Metronum » pour organiser « L'Evènement des Apprentis-Musiciens »"))
        .put( financiers, new Partner(
            "Financiers", "/images/partners/midiPyrenees.png",
            "Le Conseil Régional Midi-Pyrénées soutient l'association Topophone pour la mise en place de ses « Actions Educatives ». "
            + "Elle accompagne l'association sur son fonctionnement au titre de la Politique de la Ville."))
        .put( financiers, new Partner(
            "Financiers", "/images/partners/caisseDepot.png",
            "Le groupe Caisse des Dépôts est un groupe public, investisseur de long terme au service de l’intérêt général et du développement économique du pays. "
                + "Les actions de mécénat de la Caisse des Dépôts visent avant tout à favoriser l’accès à la culture d’un large public. "
                + "En phase avec les évolutions et les besoins de la société, elles sont portées par des valeurs fortes : la modernité, l’ouverture, le suivi sur le long terme. "
                + "Le groupe Caisse des Dépôts soutient l'association depuis 2 ans pour le développement de ses Actions Educatives, "
                + "ainsi que pour la mise en place du projet « L'Evènement des Apprentis-Musiciens »"))
        .put( financiers, new Partner(
            "Financiers", "/images/partners/fdbp.png",
            "La Banque Populaire revendique des valeurs de responsabilité, de proximité et de solidarité avec son territoire. "
                + "Cet engagement s’est traduit par la création au printemps 2011 d’une Fondation d’entreprise, "
                + "impulsée par une démarche associant l’ensemble des collaborateurs de la banque. "
                + "La Fondation d'Entreprise Banque Populaire Occitane soutient l'association pour le développement de ses « Actions Educatives », "
                + "ainsi que pour la mise en place du projet « L'Evènement des Apprentis-Musiciens »"))
        
        .put( financiers, new Partner(
            "Financiers", "/images/partners/franceactive.png",
            "France Active est un réseau de proximité qui aide les personnes en difficulté et finance les entreprises solidaires "
                + "(insertion par l’activité économique, associations d’utilité sociale). "
                + "Topophone est accompagné par Midi-Pyrénées Active au titre du \"Contrat d’amorçage associatif\",  "
                + "qui a pour objectif de proposer aux petites associations en création une première marche vers la structuration financière."))
        
        .put( operationnels, new Partner(
            "Opérationnels", "/images/partners/mlep.png",
            "Mouvement laïque d'éducation populaire, la Ligue de l'Enseignement est une fédération regroupant diverses associations adhérentes. "
            + "Topophone est affilié à la Ligue de l’Enseignement 31 et bénéficie, outre les services proposés à tout adhérent (formations, rencontres...) "
            + "d’un accompagnement individualisé sur la partie « actions éducatives » "
            + "(réunions de travail, mise en relation avec des structures péri et extra scolaires...)."))
        
        .put( operationnels, new Partner(
            "Opérationnels", "/images/partners/inspecAca.jpg",
            "Topophone travaille en lien avec L'Inspection Académique de la Haute-Garonne dans le cadre des actions actions éducatives. "
                + "L'association s'appuie sur l'Inspection Académique pour la construction de ses contenus pédagogiques ainsi que pour la mise en place de ses "
                + "interventions au sein des structures scolaires."))
        .put( operationnels, new Partner(
            "Opérationnels", "/images/partners/producson.png",
            "Fondé en 1994, Produc’son est un studio d’enregistrement et de répétition indépendant pour les particuliers et les professionnels."
                +" Il accompagne nos artistes lors de l’enregistrement de morceaux."
                +"Cyril Château, gérant du studio, accueille également des groupes de jeunes auprès desquels Topophone intervient afin de leur faire"
                + " découvrir le lieu et d’enregistrer les morceaux qu’ils ont créé lors des ateliers éducatifs."))
       
        .put( operationnels, new Partner(
            "Opérationnels", "/images/partners/gandi.png",
            "Gandi SAS est une société française d'enregistrement de noms de domaine et hébergeur web."
                +"Elle constitue une alternative crédible pour tous ceux qui veulent être présents sur le Web. A ce titre,"
                + " Gandi apporte un coup de pouce à Topophone pour la mise en place et le lancement de son site internet."))
        
        
        .put( operationnels, new Partner(
            "Opérationnels", "/images/partners/mapcu.png",
            "Le MAPCU, (Mouvement Associatif Pour les Cultures Urbaines) est un collectif d'acteurs de terrains réunis pour promouvoir la culture et les Sports Urbains. "
                + "L’association se donne comme objectifs d’être une force de représentation, de médiation et de proposition auprès des institutions publiques et de participer "
                + "activement à la promotion des cultures urbaines (musique, graff, danse, sports)."
                + "Le MAPCU met son studio d'enregistrement professionnel à dispotition de l'association, afin de permettre aux jeunes de finaliser leur création dans des conditions professionnelles."
                ))
        
        .build();
        
        
//    .put(institutionnels,
//        new Partner("Institutionnels", "/images/partners/.png",
//            "<span class=\"bold\">Le fonds social européen</span> (FSE) est l'un des fonds structurels de l'Union européenne. Il contribue à l'objectif \"Compétitivité régionale et emploi\" de la politique de cohésion de l'Union européenne. <br> Le FSE soutient Topophone sur les actions en CLAE et en entreprises."))
//        .put(institutionnels,
//            new Partner("Institutionnels", "/images/partners/peja.png",
//                "Le <span class=\"bold\">programme Européen jeunesse en action</span> apporte une aide financière et pédagogique aux projets initiés et réalisés par les groupes de jeunes de 15-30 ans. L'objectif est de soutenir la prise d’initiative des jeunes, de développer l’esprit d’entreprise et la créativité des jeunes. Le PEJA apporte un soutien à l'association sur le développement des actions éducatives en école."))
//
//        .put(associatifs,
//            new Partner("Associatifs", "/images/partners/microphages.png",
//                "<span class=\"bold\">Les Musicophages</span> , est un centre de ressources des Musiques Actuelles. Topophone est suivi par les Musicophages dans le cadre de leur action « pépinière et accompagnement de projets » au travers de réunions hebdomadaires individuelles, et encadrées par des professionnels (producteur artistique, directeur de centre de loisirs, webmaster, documentaliste)."))
//        .put(associatifs,
//            new Partner("Associatifs", "/images/partners/bestiaire.png",
//                "<span class=\"bold\">Le Bestiaire</span> est une association de « création et production d'événements culturels et divertissants dans un univers articulé autour de ses espèces artistiques protégées dans le but de mélanger les genres et les gens. » Le Bestiaire apporte une aide utile à Topophone sur toutes les questions relatives au contexte des Musiques Actuelles (cadre juridique et économique, réseaux…)."))
//        .build();
  }

}
