# Installations

## Prérequis

- Avoir une base de données MySQL
- un serveur tomcat
- Avoir Maven installé sur votre machine
- Avoir java avec le jdk et jre 15


## Installation

### Mettre en place la base de donné

Importer le script de base de données dans votre 

### Lancer le serveur

Pour lancer le serveur, ouvrez une invite de commande ou un terminal , rendez vous dans le dossier du projet et dans le dossier `EtablissementScolaire-presentation` faites la commande `mvn clean package tomcat7:run`

Il se peut que vous ayez des "erreurs", elles sont dû à la version de tomcat. L'application elle fonctionne sans aucun problème. vous pouvez y accéder via l'url : `http://localhost:8080/etablissement`

Vous pouvez vous connectez avec les identifiants suivant : 

User : responsable.etude@gmail.com
Password : responsable


# Les test unitaires

## Prérequis

- Avoir java avec le jdk et jre 15
- Avoir maven d'installer

## Lancement

Il y a des tests de la couche dao et un test de la couche service

Vous trouverez la classe de test de la couche DAO dans le fichier suiviant : `EtablissementScolaire-dao/src/test/java/eu.ensup.etablissementscolaire/DaoTest.java.java`
Vous trouverez la classe de test de la couche service dans le fichier suiviant : `EtablissementScolaire-service/src/test/java/eu.ensup.etablissementscolaire/ServiceTest.java`

Pour que les tests de la couche dao fonctionne il faut une base de donnée MYSQL avec le base de données du projet. Vous trouverez le dump dans le dossier `DB` à la racine du projet.

Pour lancer seuleument les tests de la couche service vous devez d'abord accéder au dossier `EtablissementScolaire-service` du projet dans une invite de commande (winodws) ou un terminal (linux et MacOS).

Ensuite executez la commande : `mvn clean test` pour lancer les tests.

