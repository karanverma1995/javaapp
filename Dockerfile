FROM tomcat:8-jre8

WORKDIR /usr/local/tomcat/webapps/
ADD SpringMvcCRUDExample-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD "catalina.sh run"

