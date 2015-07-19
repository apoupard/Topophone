FROM tomcat:8-jre8
MAINTAINER Adrien Poupard <adrien.poupard@gmail.com>

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY topophone-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]