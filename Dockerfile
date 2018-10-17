FROM tomcat:8-jre8

WORKDIR /usr/local/tomcat/webapps/
ADD SpringMvcCRUDExample-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

RUN /usr/local/tomcat/bin/startup.sh

RUN /usr/local/tomcat/bin/catalina.sh run

