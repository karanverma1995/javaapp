From tomcat:8-jre8

# Maintainer
MAINTAINER "xxx <xxx@gmail.com">

# Copy to images tomcat path
ADD  SpringMvcCRUDExample-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
