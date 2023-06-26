FROM tomcat:11.0.0-jre17
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD [ "catalina.sh", "run" ]