package io.enscene.topophone.widget.resource;

import io.enscene.topophone.widget.model.partner.Partner;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("partners")
public class PartnerResource {

  private final Configuration freemakerConfig;

  @Inject
  PartnerResource(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Collection<Partner>> getPartners() throws IOException, TemplateException {
    return ImmutableMultimap
        .<String, Partner>builder()
        .put(
            "Institutionnels",
            new Partner(
                "Institutionnels",
                "/images/partners/fse.png",
                "<span class=\"bold\">Le fonds social européen</span> (FSE) est l'un des fonds structurels de l'Union européenne. Il contribue à l'objectif \"Compétitivité régionale et emploi\" de la politique de cohésion de l'Union européenne. <br> Le FSE soutient Topophone sur les actions en CLAE et en entreprises."))
        .put(
            "Institutionnels",
            new Partner(
                "Institutionnels",
                "/images/partners/peja.png",
                "Le <span class=\"bold\">programme Européen jeunesse en action</span> apporte une aide financière et pédagogique aux projets initiés et réalisés par les groupes de jeunes de 15-30 ans. L'objectif est de soutenir la prise d’initiative des jeunes, de développer l’esprit d’entreprise et la créativité des jeunes. Le PEJA apporte un soutien à l'association sur le développement des actions éducatives en école."))
        .put(
            "Privés",
            new Partner(
                "Privés",
                "/images/partners/producson.png",
                "Fondé en 1994, <span class=\"bold\">Produc’son</span> est un studio d’enregistrement et de répétition indépendant pour les particuliers et les professionnels. <br> Il accompagne nos artistes lors de l’enregistrement de morceaux. <br> Cyril Château, gérant du studio, accueille également des groupes de jeunes auprès desquels Topophone intervient afin de leur faire découvrir le lieu et d’enregistrer les morceaux qu’ils ont créé lors des ateliers éducatifs."))
        .put(
            "Privés",
            new Partner(
                "Privés",
                "/images/partners/gandi.png",
                "<span class=\"bold\">Gandi</span> SAS est une société française d'enregistrement de noms de domaine et hébergeur web. <br> Elle constitue une alternative crédible pour tous ceux qui veulent être présents sur le Web. A ce titre, Gandi apporte un coup de pouce à Topophone pour la mise en place et le lancement de son site internet."))
        .put(
            "Associatifs",
            new Partner(
                "Associatifs",
                "/images/partners/mlep.png",
                "Mouvement laïque d'éducation populaire, <span class=\"bold\">la Ligue de l'Enseignement</span> est une fédération regroupant diverses associations adhérentes. Topophone est affilié à la Ligue de l’Enseignement 31 et bénéficie, outre les services proposés à tout adhérent (formations, rencontres…) d’un accompagnement individualisé sur la partie « actions éducatives » (réunions de travail, mise en relation avec des structures péri et extra scolaires…)."))
        .put(
            "Associatifs",
            new Partner(
                "Associatifs",
                "/images/partners/microphages.png",
                "<span class=\"bold\">Les Musicophages</span> , est un centre de ressources des Musiques Actuelles. Topophone est suivi par les Musicophages dans le cadre de leur action « pépinière et accompagnement de projets » au travers de réunions hebdomadaires individuelles, et encadrées par des professionnels (producteur artistique, directeur de centre de loisirs, webmaster, documentaliste)."))
        .put(
            "Associatifs",
            new Partner(
                "Associatifs",
                "/images/partners/bestiaire.png",
                "<span class=\"bold\">Le Bestiaire</span> est une association de « création et production d'événements culturels et divertissants dans un univers articulé autour de ses espèces artistiques protégées dans le but de mélanger les genres et les gens. » Le Bestiaire apporte une aide utile à Topophone sur toutes les questions relatives au contexte des Musiques Actuelles (cadre juridique et économique, réseaux…)."))
        .put(
            "Associatifs",
            new Partner(
                "Associatifs",
                "/images/partners/franceactive.png",
                "<span class=\"bold\">France Active</span> est un réseau de proximité qui aide les personnes en difficulté et finance les entreprises solidaires (insertion par l’activité économique, associations d’utilité sociale).\" Topophone est accompagné par Midi-Pyrénées Active au titre du \"Contrat d’amorçage associatif\", qui a pour objectif de proposer aux petites associations en création une première marche vers la structuration financière."))
        .build().asMap();
  }

  @GET
  @Path("/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("template") String template) throws IOException,
      TemplateException {
    Template temp = freemakerConfig.getTemplate("partner/" + template + ".html");
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of("partners", getPartners()), out);
    // return Processor.process(out.toString());
    return out.toString();
  }

}
