# wordfinder

## Usage

### Running maven and war (not best practice to run the war with -jar but fine for development, also tomcat suspend debug included):

```
mvn clean install && java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/wordfinder-0.0.1-SNAPSHOT.war
```

### Set up DB

 - Install MySQL for your env
 - Run:
 ```
 CREATE DATABASE IF NOT EXISTS `wordfinder`;
 USE `wordfinder`;

 DROP TABLE IF EXISTS `wordgrid`;

 CREATE TABLE `wordgrid`(
 	`id` int(11) NOT NULL AUTO_INCREMENT,
     `character_grid` varchar(3000) DEFAULT NULL,
     `name` varchar(45) DEFAULT NULL,
     PRIMARY KEY (`id`)
 ) ENGINE=InnoDB auto_increment=1 default charset=latin1;
 ```