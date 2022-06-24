FROM tomcat:8.5.81-jre11-openjdk

COPY docker-additional/tomcat-users.xsd /usr/local/tomcat/conf
COPY target/Currency-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/currency.war
CMD ["catalina.sh", "run"]