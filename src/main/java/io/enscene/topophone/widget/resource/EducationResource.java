package io.enscene.topophone.widget.resource;

import io.enscene.topophone.widget.model.education.Education;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Path("education")
public class EducationResource {

  private final Configuration freemakerConfig;

  @Inject
  EducationResource(Configuration freemakerConfig) {
    this.freemakerConfig = freemakerConfig;
  }
  
  private Map<String, Education> getEducations(){
    return ImmutableMap.<String, Education>builder()
        .put("creation", new Education("creation", "<h1>Création musicale</h1><h3>L'atelier</h3><p>Dans cet atelier, les participants découvrent et prennent part à toutes les étapes d’une création musicale. Ils sont alors confrontés aux différentes facettes du musicien : interpréter une mélodie (instruments, voix), créer l’accompagnement harmonique et/ou rythmique d’un morceau, se mettre en situation de scène… En fonction des formats d’intervention choisis, les ateliers poursuivent différentes finalités : interprétation d’un morceau, création d’un petit spectacle (concert, conte musical) ou enregistrement dans un studio professionnel.</p><h3>Objectifs généraux</h3><ul><li>Utiliser la musique comme un vecteur de partage, de respect et d’ouverture à l’autre</li> <li>Permettre aux participants de construire un projet en groupe </li> <li>Faire découvrir les esthétiques propres aux musiques actuelles (rock, jazz, musique du monde...)</li> <li>Utiliser la création musicale comme un outil de connaissances pluridisciplinaires (arts, français, histoire, géographie...)</li></ul>"
            , "/images/education/creation.png"))
        .put("initiation", new Education("initiation", "<h1>Initiation à l’écoute</h1><h3>L'atelier</h3><p>De l’écoute de bruits ambiants à l’analyse d’œuvres musicales, ce programme permet aux participants d’affiner leur capacité d’écoute et d’acquérir des compétences techniques afin d’être « acteurs » de leur écoute. La démarche globale associe systématiquement des phases d’écoute (de sons ambiants, d’œuvres) à des phases de production (dessin, écriture, danse, rythmique). L’atelier favorise l’imagination, la créativité des participants et leur apporte des connaissances musicales (timbre, hauteur, rythme…) ainsi que d’autres transversales aux programmes scolaires (histoire, géographie…).</p><h3>Objectifs généraux</h3><ul><li>Développer la capacité d’écoute des participants (attention, concentration)</li><li>Multiplier les références auditives et culturelles</li><li>Utiliser l’écoute active d’œuvres pour favoriser l’expression personnelle</li><li>Permettre aux élèves d’être en capacité d’analyser les principales caractéristiques</li></ul>"
            , "/images/education/initiation.png"))
        .put("meeting", new Education("meeting", "<h1>Rencontre d’artistes</h1> <h3>L'atelier</h3><p>Des musiciens professionnels interviennent en classe durant 1 à 2 heures. Sur la base d’un récit d’expérience suivi d’un concert « interactif », ce moment permet la rencontre, l’échange et le partage entre musiciens et jeune public.</p><h3>Objectifs généraux</h3><ul><li>Sensibiliser et ouvrir les élèves à la découverte musicale par la rencontre et l’échange avec des musiciens professionnels.</li><li>Utiliser la rencontre avec des artistes comme un vecteur de connaissances et d’enrichissement individuel</li></ul>"
            , "/images/education/meeting.png")).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Education getEducation(@PathParam("id") String id) throws IOException, TemplateException {
    return getEducations().get(id);
  }
  
  @GET
  @Path("/{id}/{template}")
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlProfile(@PathParam("id") String id, @PathParam("template") String template) throws IOException, TemplateException {
    Template temp = freemakerConfig.getTemplate("education/"+template+".html");
    StringWriter out = new StringWriter();
    temp.process(ImmutableMap.of("edu", getEducation(id)), out);
    return out.toString();
  }

}
