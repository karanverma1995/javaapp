FROM tomcat:8-jre8

ADD SpringMvcCRUDExample-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
ADD script.sh /var/lib/jenkins/workspace/javaapp@2/

CMD ["./script.sh"]

