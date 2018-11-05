# wordfinder

#Usage

## Running maven and war (not best practice to run the war with -jar but fine for development, also tomcat suspend debug included):

mvn clean install && java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/wordfinder-0.0.1-SNAPSHOT.war

## Set up DB
